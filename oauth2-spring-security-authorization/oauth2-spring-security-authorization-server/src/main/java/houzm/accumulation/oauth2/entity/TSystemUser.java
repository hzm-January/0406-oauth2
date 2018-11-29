package houzm.accumulation.oauth2.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Package: houzm.accumulation.oauth2.entity
 * Author: houzm
 * Date: Created in 2018/11/3 13:09
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 用户 角色
 *  @Entity 指明这是一个与数据库表映射的实体类
 *  @Id 指明这个属性映射为数据库的主键
 *  @GeneratedValue 默认使用主键生成方式为自增
 *
 */
@Entity
@Table(name = "T_SYSTEM_USER")
public class TSystemUser implements Serializable{

    @Id
    @Column(name = "U_ID")
    private Long id;

    @Column(name = "U_USERNAME")
    private String username;

    @Column(name = "U_PASSWORD")
    private String password;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(
            name = "T_SYSTEM_USER_ROLES",
            joinColumns = {
                    @JoinColumn(name = "UR_USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "UR_ROLE_ID")
            }
    )
    private List<TSystemRole> roles;

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TSystemRole> getRoles() {
        return roles;
    }

    public void setRoles(List<TSystemRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "TSystemUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
