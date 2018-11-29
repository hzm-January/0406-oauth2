package houzm.accumulation.oauth2.ctrl;

import houzm.accumulation.oauth2.IdWorker;
import houzm.accumulation.oauth2.entity.TSystemUser;
import houzm.accumulation.oauth2.repository.TSystemUserJPA;
import houzm.accumulation.oauth2.service.TSystemUserService;
import houzm.accumulation.oauth2.util.PasswordEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: houzm.accumulation.oauth2.ctrl
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/3 16:59
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： t_system_user controller
 *  registry 注册
 *
 */

@RestController
@RequestMapping("/")
public class TSystemCtrl {

    @Autowired
    private TSystemUserService systemUserService;

    @PostMapping(value = "/registry")
    public TSystemUser registry(TSystemUser user) {
        user.setPassword(PasswordEncoderUtil.passwordEncoder(user.getPassword()));
        user.setId(IdWorker.id());
        return systemUserService.save(user);
    }
}

