package com.luoqincai.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Server {
    @Id
    private String id;

    @Column(nullable = false)
    private String macAddress;

    @Column(nullable = false)
    private String uri;

    @Column(nullable = false)
    private Date registerTime;

    @Column(nullable = false)
    private Date lastLoginTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
