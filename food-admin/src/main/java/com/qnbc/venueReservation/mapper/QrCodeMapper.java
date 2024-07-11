package com.qnbc.venueReservation.mapper;

import java.util.List;
import com.qnbc.venueReservation.domain.QrCode;

/**
 * 二维码管理Mapper接口
 * 
 * @author guzj
 * @date 2023-12-27
 */
public interface QrCodeMapper 
{
    /**
     * 查询二维码管理
     * 
     * @param id 二维码管理主键
     * @return 二维码管理
     */
    public QrCode selectQrCodeById(Long id);

    /**
     * 查询二维码管理列表
     * 
     * @param qrCode 二维码管理
     * @return 二维码管理集合
     */
    public List<QrCode> selectQrCodeList(QrCode qrCode);

    /**
     * 新增二维码管理
     * 
     * @param qrCode 二维码管理
     * @return 结果
     */
    public int insertQrCode(QrCode qrCode);

    /**
     * 修改二维码管理
     * 
     * @param qrCode 二维码管理
     * @return 结果
     */
    public int updateQrCode(QrCode qrCode);

    /**
     * 删除二维码管理
     * 
     * @param id 二维码管理主键
     * @return 结果
     */
    public int deleteQrCodeById(Long id);

    /**
     * 批量删除二维码管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQrCodeByIds(Long[] ids);
}
