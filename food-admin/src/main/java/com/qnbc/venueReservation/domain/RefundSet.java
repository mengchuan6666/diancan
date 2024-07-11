package com.qnbc.venueReservation.domain;

import com.qnbc.venueReservation.core.annotation.Excel;
import com.qnbc.venueReservation.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 退款申请对象 refund_set
 *
 * @author guzj
 * @date 2023-10-05
 */
public class RefundSet extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 客服地址
	 */
	@Excel(name = "客服地址")
	private String refundPic;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setRefundPic(String refundPic) {
		this.refundPic = refundPic;
	}

	public String getRefundPic() {
		return refundPic;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("id", getId())
			.append("refundPic", getRefundPic())
			.toString();
	}
}
