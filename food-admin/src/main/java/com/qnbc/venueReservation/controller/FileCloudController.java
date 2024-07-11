package com.qnbc.venueReservation.controller;

import com.qnbc.venueReservation.config.interceptor.AuthAccess;
import com.qnbc.venueReservation.core.domain.AjaxResult;
import com.qnbc.venueReservation.response.FileResponse;
import com.qnbc.venueReservation.utils.MinioUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件上传相关接口
 */
@RestController
@RequestMapping("/fileCloud")
public class FileCloudController {

	@Resource
	private MinioUtils minioUtils;

	/**
	 * 文件上传接口
	 *
	 * @param file 前端传递过来的文件
	 * @return
	 * @throws IOException
	 */
	@AuthAccess
	@PostMapping("/upload")
	public AjaxResult upload(@RequestParam MultipartFile file) throws IOException {
		List<MultipartFile> multipartFile = new ArrayList<>();
		multipartFile.add(file);
		List<FileResponse> upload = minioUtils.upload(multipartFile);
		return AjaxResult.success("上传成功", upload.get(0).getFileUrl());
	}
}
