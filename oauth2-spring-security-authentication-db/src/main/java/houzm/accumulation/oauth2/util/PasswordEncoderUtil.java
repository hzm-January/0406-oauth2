package houzm.accumulation.oauth2.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Package: houzm.accumulation.oauth2.util
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/4 13:39
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： PasswordEncoderUtil
 */
public class PasswordEncoderUtil {
    private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public static String passwordEncoder(String password) {
        return passwordEncoder.encode(password);
    }
}
