package com.qnbc.venueReservation.utils;

import cn.hutool.core.lang.Assert;

import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author gzj
 * @Date 2023/9/20 11:01
 * @Version 1.0
 **/

public class BigDecimalUtils {

	/**
	 * 元转分
	 * @param amount
	 * @return
	 */

	/**
	 * 将单位为元的金额转换为单位为分
	 *
	 * @param yuan 单位为元的字符型值
	 * @return
	 */
	public static int yuan2Fen(String yuan) {
		int value = 0;

		try {
			BigDecimal var1 = new BigDecimal(yuan);
			BigDecimal var2 = new BigDecimal(100);
			BigDecimal var3 = var1.multiply(var2);
			value = Integer.parseInt(var3.stripTrailingZeros().toPlainString());
		} catch (Exception e) {
			throw new IllegalArgumentException(String.format("非法金额[%s]", yuan));
		}

		Assert.isTrue(value >= 0, String.format("非法金额[%s]", yuan));
		return value;
	}


}

