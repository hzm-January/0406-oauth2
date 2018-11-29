package houzm.accumulation.oauth2.service;

import houzm.accumulation.oauth2.entity.TSystemUser;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Package: houzm.accumulation.oauth2.service
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/4 14:21
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TSystemUserService
 */
public interface TSystemUserService extends UserDetailsService {
    TSystemUser save(TSystemUser user);
}
