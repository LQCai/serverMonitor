package com.luoqincai.service.impl;

import com.luoqincai.service.ThriftServerService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ThriftServerServiceImpl implements ThriftServerService.Iface {
    @Override
    public String getDate(String userName) throws TException {
        Date now=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("今天是"+"yyyy年MM月dd日 E kk点mm分");
        String nowTime = simpleDateFormat.format(now);
        return "Hello " + userName + "\n" + nowTime;
    }
}
