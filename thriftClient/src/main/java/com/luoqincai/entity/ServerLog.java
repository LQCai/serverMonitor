package com.luoqincai.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ServerLog {
    public static final long TYPE_CPU = 1;
    public static final long TYPE_MEMORY = 2;
    public static final long TYPE_IO = 3;

    @Id
    private String id;

    @Column(nullable = false)
    private String serverId;

    @Column(nullable = false)
    private String log;

    @Column(nullable = false)
    private Integer value;

    @Column(nullable = false)
    private long type;

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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }
}
