package houzm.accumulation.oauth2.service;

import houzm.accumulation.oauth2.entity.TSystemRole;
import houzm.accumulation.oauth2.entity.TSystemUser;
import houzm.accumulation.oauth2.repository.TSystemUserJPA;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Package: houzm.accumulation.oauth2.service
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/3 15:59
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 认证
 */
@Service(value = "systemUserService")
public class TSystemUserServiceImpl implements TSystemUserService {
    private Logger logger = LoggerFactory.getLogger(TSystemUserServiceImpl.class);
    @Autowired
    private TSystemUserJPA systemUserJPA;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username: "+ username);
        TSystemUser user = systemUserJPA.findByUsername(username);
        logger.debug("user {}", user.getPassword());
        List<GrantedAuthority> authorities =  new ArrayList<>();
        List<TSystemRole> roles = user.getRoles();
        for (TSystemRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        if (user == null) {
            throw new UsernameNotFoundException("未查询到用户:"+username);
        }
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public TSystemUser save(TSystemUser user) {
        TSystemUser userSaved = systemUserJPA.save(user);
        return userSaved;
    }
}
