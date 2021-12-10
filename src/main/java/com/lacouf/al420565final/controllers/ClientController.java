package com.lacouf.al420565final.controllers;

import com.lacouf.al420565final.utils.ClientFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lacouf.al420565final.model.Client;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {

    private final List<Client> clients = ClientFactory.getClients();

    @GetMapping
    public List<Client> getAll(){
        return clients;
    }

    @GetMapping("/hommes")
    public List<Client> getHommes(){
        return clients.stream().filter(c -> "M".equalsIgnoreCase(c.getGender())).collect(Collectors.toList());
    }

    @GetMapping("/ontariens")
    public List<Client> getOntariens(){
        return clients.stream().filter(c -> "ON".equalsIgnoreCase(c.getProvince())).collect(Collectors.toList());
    }
}