package com.qnbc.venueReservation.utils;

import com.qnbc.venueReservation.response.FileResponse;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.Result;
import io.minio.errors.*;
import io.minio.messages.DeleteError;
import io.minio.messages.Item;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author gzj
 * @description： minio工具类
 * @version：3.0
 */
@Slf4j
@Component
public class MinioUtils {
	@Autowired
	private MinioClient minioClient;

	@Value("${minio.bucketName}")
	private String bucketName;

	/**
	 * description: 判断bucket是否存在，不存在则创建
	 *
	 * @return: void
	 */
	public void existBucket(String name) {
		try {
			boolean exists = minioClient.bucketExists(name);
			if (!exists) {
				minioClient.makeBucket(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建存储bucket
	 *
	 * @param bucketName 存储bucket名称
	 * @return Boolean
	 */
	public Boolean makeBucket(String bucketName) {
		try {
			minioClient.makeBucket(bucketName);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 删除存储bucket
	 *
	 * @param bucketName 存储bucket名称
	 * @return Boolean
	 */
	public Boolean removeBucket(String bucketName) {
		try {
			minioClient.removeBucket(bucketName);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * description: 上传文件
	 *
	 * @param multipartFile
	 * @return: java.lang.String
	 */
	public List<FileResponse> upload(List<MultipartFile> multipartFile) {
		List<FileResponse> elevatorFileResponses = new ArrayList<>(multipartFile.size());
		for (MultipartFile file : multipartFile) {
			FileResponse oaFileResponse = new FileResponse();
			String fileName = file.getOriginalFilename();
			String[] split = fileName.split("\\.");
			if (split.length > 1) {

				fileName = split[0] + "_" + System.currentTimeMillis() + "." + split[1];
			} else {
				fileName = fileName + System.currentTimeMillis();
			}
			oaFileResponse.setFileName(fileName);
			String i = fileName.substring(0, fileName.indexOf("."));
			String fileType = fileName.substring(i.length() + 1, fileName.length());
			oaFileResponse.setFileType(fileType);
			InputStream in = null;
			try {
				in = file.getInputStream();
				minioClient.putObject(bucketName, fileName, in, new PutObjectOptions(in.available(), -1));
				oaFileResponse.setFileSize((int) file.getSize());
				oaFileResponse.setFileUrl("http://localhost:9000/" + bucketName + "/" + fileName);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			elevatorFileResponses.add(oaFileResponse);
		}
		return elevatorFileResponses;
	}


	/**
	 * description: 下载文件
	 *
	 * @param fileName
	 * @return: org.springframework.http.ResponseEntity<byte [ ]>
	 */
	public ResponseEntity<byte[]> download(String fileName) {
		ResponseEntity<byte[]> responseEntity = null;
		InputStream in = null;
		ByteArrayOutputStream out = null;
		try {
			in = minioClient.getObject(bucketName, fileName);
			out = new ByteArrayOutputStream();
			IOUtils.copy(in, out);
			//封装返回值
			byte[] bytes = out.toByteArray();
			HttpHeaders headers = new HttpHeaders();
			try {
				headers.add("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			headers.setContentLength(bytes.length);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setAccessControlExposeHeaders(Collections.singletonList("*"));
			responseEntity = new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseEntity;
	}

	/**
	 * 查看文件对象
	 *
	 * @param bucket 存储bucket名称
	 * @return 存储bucket内文件对象信息
	 */
	public List<FileResponse> listFiles(String bucket) {
		Iterable<Result<Item>> results = null;
		try {
			results = minioClient.listObjects("OAbuckets");
			for (Result<Item> result : results) {
				Item item = result.get();
				System.out.println(item.lastModified() + ", " + item.size() + ", " + item.objectName());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ArrayList<>();
	}


	/**
	 * 批量删除文件对象
	 *
	 * @param bucketName 存储bucket名称
	 * @param objects    对象名称集合
	 * @return
	 */
	public Iterable<Result<DeleteError>> removeObjects(String bucketName, List<String> objects) {
		Iterable<Result<DeleteError>> results = minioClient.removeObjects(bucketName, objects);
		for (Result<DeleteError> result : results) {
			DeleteError error = null;
			try {
				error = result.get();
			} catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException |
					 InvalidResponseException | IOException | NoSuchAlgorithmException | XmlParserException |
					 InvalidBucketNameException e) {
				log.error(e.toString());
				throw new RuntimeException(e);
			}
		}
		return results;
	}


	//根据bucket和文件名称获取在线查看地址
	public String getUrl(String objectName) {
		String url = null;
		try {
			url = minioClient.getObjectUrl(bucketName, objectName);
		} catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidBucketNameException |
				 InvalidKeyException | InvalidResponseException | IOException | NoSuchAlgorithmException |
				 XmlParserException e) {
			throw new RuntimeException(e);
		}
		return url;
	}


}

