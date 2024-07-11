package com.qnbc.venueReservation.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.qnbc.venueReservation.entity.User;
import com.qnbc.venueReservation.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.qnbc.venueReservation.mapper.QrCodeMapper;
import com.qnbc.venueReservation.domain.QrCode;
import com.qnbc.venueReservation.service.IQrCodeService;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 二维码管理Service业务层处理
 *
 * @author guzj
 * @date 2023-12-27
 */
@Service
public class QrCodeServiceImpl implements IQrCodeService {
	@Autowired
	private QrCodeMapper qrCodeMapper;

	@Resource
	QrConfig qrconig;

	@Value("${picfile}")
	private String picfile;


	public String generateFile(String content, File file) throws FileNotFoundException {


		QrCodeUtil.generate(content, qrconig, file);
		return "http://localhost:9091/uploadPic/" + file.getName();
	}


	//输出到流
	public void generateStream(String content, HttpServletResponse response) throws IOException {
		QrCodeUtil.generate(content, qrconig, "png", response.getOutputStream());
	}

	/**
	 * 查询二维码管理
	 *
	 * @param id 二维码管理主键
	 * @return 二维码管理
	 */
	@Override
	public QrCode selectQrCodeById(Long id) {
		return qrCodeMapper.selectQrCodeById(id);
	}

	/**
	 * 查询二维码管理列表
	 *
	 * @param qrCode 二维码管理
	 * @return 二维码管理
	 */
	@Override
	public List<QrCode> selectQrCodeList(QrCode qrCode) {
		return qrCodeMapper.selectQrCodeList(qrCode);
	}

	/**
	 * 新增二维码管理
	 *
	 * @param qrCode 二维码管理
	 * @return 结果
	 */
	@Override
	public int insertQrCode(QrCode qrCode) {
		User currentUser = TokenUtils.getCurrentUser();
		qrCode.setCreatedBy(currentUser.getNickname());
		qrCode.setCreatedTime(new Date());
		String qrUrl = "";
		try {
			qrUrl = generateFile(qrCode.toString(), new File(picfile + "/QR" + System.currentTimeMillis() + ".jpg"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		qrCode.setCodeUrl(qrUrl);
		return qrCodeMapper.insertQrCode(qrCode);
	}

	/**
	 * 修改二维码管理
	 *
	 * @param qrCode 二维码管理
	 * @return 结果
	 */
	@Override
	public int updateQrCode(QrCode qrCode) {
		return qrCodeMapper.updateQrCode(qrCode);
	}

	/**
	 * 批量删除二维码管理
	 *
	 * @param ids 需要删除的二维码管理主键
	 * @return 结果
	 */
	@Override
	public int deleteQrCodeByIds(Long[] ids) {
		return qrCodeMapper.deleteQrCodeByIds(ids);
	}

	/**
	 * 删除二维码管理信息
	 *
	 * @param id 二维码管理主键
	 * @return 结果
	 */
	@Override
	public int deleteQrCodeById(Long id) {
		return qrCodeMapper.deleteQrCodeById(id);
	}
}
