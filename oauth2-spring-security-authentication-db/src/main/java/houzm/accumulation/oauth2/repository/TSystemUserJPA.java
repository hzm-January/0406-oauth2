package houzm.accumulation.oauth2.repository;

import houzm.accumulation.oauth2.entity.TSystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Package: houzm.accumulation.oauth2.repository
 * Author: houzm
 * Date: Created in 2018/11/3 15:54
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TSystemUserJPA
 */
public interface TSystemUserJPA extends JpaRepository<TSystemUser, Long> {
    TSystemUser findByUsername(String username);
}
