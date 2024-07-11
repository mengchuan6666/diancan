package com.qnbc.venueReservation.utils;

import com.qnbc.venueReservation.core.domain.AjaxResult;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.Objects;

/**
 * @Description TODO
 * @Author gzj
 * @Date 2023/12/28 17:07
 * @Version 1.0
 **/

public class UploadUtils {

	public AjaxResult upload(MultipartFile file) throws Exception {
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

}
