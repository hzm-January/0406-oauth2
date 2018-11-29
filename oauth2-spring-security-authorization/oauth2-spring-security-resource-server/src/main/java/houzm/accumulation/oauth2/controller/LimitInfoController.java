package houzm.accumulation.oauth2.controller;

import houzm.accumulation.oauth2.pojo.LimitInfo;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Package: houzm.accumulation.oauth2.controller
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/4 16:19
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： t_system_user controller
 */
@RestController
@RequestMapping("/api/")
public class LimitInfoController {

    @GetMapping(value = "limitinfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public LimitInfo limit() throws JsonProcessingException {
        System.out.println("我来了");
        System.out.println("你是什么："+ new ObjectMapper().writeValueAsString(SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LimitInfo limitInfo = new LimitInfo();
//        limitInfo.setPassword(user.getPassword());
        limitInfo.setUsername(username);
        return limitInfo;
    }
}
