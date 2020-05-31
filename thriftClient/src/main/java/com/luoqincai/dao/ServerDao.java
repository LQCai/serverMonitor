package com.luoqincai.dao;

import com.luoqincai.entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerDao extends JpaRepository<Server, Long> {
    Server findServerByMacAddress(String macAddress);
}
