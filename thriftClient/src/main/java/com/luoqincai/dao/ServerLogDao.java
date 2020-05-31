package com.luoqincai.dao;

import com.luoqincai.entity.ServerLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerLogDao extends JpaRepository<ServerLog, Long> {
}
