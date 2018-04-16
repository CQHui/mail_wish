package com.qihui.mailwish.model;

import java.io.Serializable;

/**
 * create by chenqihui on 2018/4/5
 */
public class UserDO implements Serializable {
    private static final long serialVersionUID = 1301458515610532990L;
    private Long id;
    private String userName;
    private Integer sex;
    private String mail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
