package com.luoqincai.service.impl;

import com.luoqincai.dao.ServerDao;
import com.luoqincai.dao.ServerLogDao;
import com.luoqincai.entity.ServerLog;
import com.luoqincai.service.CollectService;
import com.luoqincai.tool.MachineTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.UUID;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private ServerDao serverDao;
    @Autowired
    private ServerLogDao serverLogDao;

    @Override
    public void CPU() {
        try {
            String[] cmd = new String[] { "/bin/sh", "", "top" };
            Process ps = Runtime.getRuntime().exec(cmd);

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String result = sb.toString();

            String serverId = serverDao.findServerByMacAddress(MachineTool.getMacAddress()).getId();

            ServerLog serverLog = new ServerLog();
            serverLog.setId(UUID.randomUUID().toString());
            serverLog.setServerId(serverId);
            serverLog.setLog(result);
            serverLog.setCreateTime(new Date());

            serverLogDao.save(serverLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean memory() {
        return false;
    }

    @Override
    public boolean disk() {
        return false;
    }
}
