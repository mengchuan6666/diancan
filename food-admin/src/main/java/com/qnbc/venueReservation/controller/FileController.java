package com.qnbc.venueReservation.controller;

import com.qnbc.venueReservation.core.domain.AjaxResult;
import com.qnbc.venueReservation.utils.UploadUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

/**
 * 上传文件映射表
 */
@RestController
@RequestMapping("/file")
@SuppressWarnings({"unchecked", "rawtypes"})
public class FileController {


	/**
	 * 上传文件
	 */
	@RequestMapping("/upload")
	public AjaxResult upload(@RequestParam("file") MultipartFile file) throws Exception {
		if (file.isEmpty()) {
			throw new Exception("上传文件不能为空");
		}
		String fileExt = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf(".") + 1);
		File path = new File(ResourceUtils.getURL("classpath:static").getPath());
		if (!path.exists()) {
			path = new File("");
		}
		File upload = new File(path.getAbsolutePath(), "../picfile");
		if (!upload.exists()) {
			upload.mkdirs();
		}
		String fileName = new Date().getTime() + "." + fileExt;
		File dest = new File(upload.getAbsolutePath() + "/" + fileName);
		file.transferTo(dest);
		return AjaxResult.success().put("data", "http://localhost:9091/uploadPic/" + fileName);
	}

	/**
	 * 下载文件
	 */
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(@RequestParam String fileName) {
		try {
			File path = new File(ResourceUtils.getURL("classpath:static").getPath());
			if (!path.exists()) {
				path = new File("");
			}
			File upload = new File(path.getAbsolutePath(), "/upload/");
			if (!upload.exists()) {
				upload.mkdirs();
			}
			File file = new File(upload.getAbsolutePath() + "/" + fileName);
			if (file.exists()) {
				/*if(!fileService.canRead(file, SessionManager.getSessionUser())){
					getResponse().sendError(403);
				}*/
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.setContentDispositionFormData("attachment", fileName);
				return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
