package com.qnbc.venueReservation.core.utils;

import com.qnbc.venueReservation.core.constant.HttpStatus;
import com.qnbc.venueReservation.core.domain.model.LoginUser;
import com.qnbc.venueReservation.core.exception.ServiceException;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

/**
 * 安全服务工具类
 *
 * @author ruoyi
 */
public class SecurityUtils
{



    /**
     * 是否为管理员
     *
     * @param userId 用户ID
     * @return 结果
     */
    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }
}
