package com.luoqincai.service;

import java.util.List;

public interface ClientService {
    /**
     * 获取客户端IP
     * @return List
     */
    List<String> getClientHosts();
}
