package com.luoqincai.service.impl;

import com.luoqincai.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public List<String> getClientHosts() {
        List<String> clientHosts = new ArrayList<>();
        List<String> serviceNames = discoveryClient.getServices();
        for(String serviceName : serviceNames){
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
            for(ServiceInstance serviceInstance : serviceInstances){
                clientHosts.add(String.format("%s", serviceInstance.getUri()));
            }
        }
        return clientHosts;
    }
}
