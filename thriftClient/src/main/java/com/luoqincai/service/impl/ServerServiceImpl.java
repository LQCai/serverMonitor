package com.luoqincai.service.impl;

import com.luoqincai.dao.ServerDao;
import com.luoqincai.service.ServerService;
import com.luoqincai.tool.MachineTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerServiceImpl implements ServerService {
    @Autowired
    private ServerDao serverDao;

    @Override
    public String getServerId() {
        String macAddress = null;
        try {
            macAddress = MachineTool.getMacAddress();
        } catch (Exception e) {
            return "";
        }
        return serverDao.findServerByMacAddress(macAddress).getId();
    }
}
