package com.luoqincai.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ServerLog {
    @Id
    private String id;

    @Column(nullable = false)
    private String serverId;

    @Column(nullable = false)
    private String log;

    @Column(nullable = false)
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
