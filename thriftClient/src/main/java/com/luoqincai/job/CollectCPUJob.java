package com.luoqincai.job;

import com.luoqincai.dao.ServerDao;
import com.luoqincai.dao.ServerLogDao;
import com.luoqincai.entity.Server;
import com.luoqincai.entity.ServerLog;
import com.luoqincai.tool.CommandTool;
import com.luoqincai.tool.MachineTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.TimerTask;
import java.util.UUID;

@Component
public class CollectCPUJob extends TimerTask {
    @Autowired
    protected ServerDao serverDao;
    @Autowired
    protected ServerLogDao serverLogDao;

    @Override
    public void run() {
        try {
            String cmd = "top";
            String result = CommandTool.execCMD(cmd);

            String macAddress = MachineTool.getMacAddress();

            String serverId = serverDao.findServerByMacAddress(macAddress).getId();

            ServerLog serverLog = new ServerLog();
            serverLog.setId(UUID.randomUUID().toString());
            serverLog.setServerId(serverId);
            serverLog.setLog(result);
            serverLog.setType(ServerLog.TYPE_CPU);
            serverLog.setValue(result.indexOf("%Cpu(s):"));
            serverLog.setCreateTime(new Date());

            serverLogDao.save(serverLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
