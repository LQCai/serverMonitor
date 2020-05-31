package com.luoqincai.aop;

import com.luoqincai.dao.ServerDao;
import com.luoqincai.entity.Server;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Date;
import java.util.UUID;

/**
 * 暂时没用到
 */
@Aspect
@Component
public class RegisterAspect {
    @Value("${server.port}")
    private String port;

    @Autowired
    private ServerDao serverDao;

    @Pointcut("@annotation(com.luoqincai.annotation.Register)")
    public void pointCut() {}

    @Before("pointCut()")
    public void register()
    {
        try {
            // 获取本地IP
            InetAddress inetAddress = InetAddress.getLocalHost();
            // 获取MAC地址
            String macAddress = getMACAddress(inetAddress);

            Server server = serverDao.findServerByMacAddress(macAddress);
            if (server == null) {
                server = new Server();
                server.setId(UUID.randomUUID().toString());
                server.setMacAddress(macAddress);
                server.setUri(inetAddress.getHostAddress() + ":" + port);
                server.setRegisterTime(new Date());
                server.setLastLoginTime(new Date());
                serverDao.save(server);
                return;
            }
            server.setLastLoginTime(new Date());
            serverDao.saveAndFlush(server);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getMACAddress(InetAddress inetAddress) throws Exception {
        // 获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
        byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();

        // 下面代码是把mac地址拼装成String
        StringBuilder stringBuffer = new StringBuilder();

        for (int i = 0; i < mac.length; i++) {
            if (i != 0) {
                stringBuffer.append("-");
            }
            // mac[i] & 0xFF 是为了把byte转化为正整数
            String s = Integer.toHexString(mac[i] & 0xFF);
            stringBuffer.append(s.length() == 1 ? 0 + s : s);
        }

        // 把字符串所有小写字母改为大写成为正规的mac地址并返回
        return stringBuffer.toString().toUpperCase();
    }
}
