package houzm.accumulation.oauth2.pojo;

import java.io.Serializable;

/**
 * Package: houzm.accumulation.oauth2.pojo
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/4 16:21
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： LimitInfo
 */
public class LimitInfo implements Serializable {
    private static final long serialVersionUID = 9202406345213482038L;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
