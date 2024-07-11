package com.qnbc.venueReservation;

import com.qnbc.venueReservation.config.AliPayConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

	@Autowired
	AliPayConfig aliPayConfig;

    @Test
    void alipay() {
		System.out.println(aliPayConfig.pay("20240114113117000000847","0.1", "测试沙箱"));
    }

}
