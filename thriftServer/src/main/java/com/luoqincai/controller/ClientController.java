package com.luoqincai.controller;

import com.luoqincai.service.ClientService;
import com.luoqincai.dto.RespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/hosts")
    public RespDTO getClientHosts()
    {
        return RespDTO.onSuc(clientService.getClientHosts());
    }
}
