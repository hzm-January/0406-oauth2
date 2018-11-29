package houzm.accumulation.oauth2.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Package: houzm.accumulation.oauth2.entity
 * Author: houzm
 * Date: Created in 2018/11/3 15:26
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： role
 */
@Entity
@Table(name = "T_SYSTEM_ROLE")
public class TSystemRole implements Serializable{

    @Id
    @Column(name = "R_ID")
    private Long id;

    @Column(name = "R_NAME")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TSystemRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
