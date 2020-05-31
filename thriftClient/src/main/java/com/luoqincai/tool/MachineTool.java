package com.luoqincai.tool;

import java.net.InetAddress;
import java.net.NetworkInterface;

public class MachineTool {
    public static String getMacAddress() throws Exception {
        // 获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
        byte[] mac = NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getHardwareAddress();

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
