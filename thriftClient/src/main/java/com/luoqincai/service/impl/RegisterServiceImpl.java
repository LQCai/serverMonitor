package com.luoqincai.service.impl;

import com.luoqincai.dao.ServerDao;
import com.luoqincai.entity.Server;
import com.luoqincai.service.RegisterService;
import com.luoqincai.tool.MachineTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Date;
import java.util.UUID;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Value("${server.port}")
    private String port;

    @Autowired
    private ServerDao serverDao;

    @Override
    public void register() {
        try {
            // 获取本地IP
            InetAddress inetAddress = InetAddress.getLocalHost();
            // 获取MAC地址
            String macAddress = MachineTool.getMacAddress();

            Server server = serverDao.findServerByMacAddress(macAddress);
            if (server == null) {
                server = new Server();
                server.setId(UUID.randomUUID().toString());
                server.setMacAddress(macAddress);
                server.setUri(inetAddress.getHostAddress() + ":" + port);
                server.setRegisterTime(new Date());
                server.setLastLoginTime(new Date());
                serverDao.saveAndFlush(server);
                return;
            }
            server.setLastLoginTime(new Date());
            serverDao.saveAndFlush(server);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
