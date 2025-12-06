package com.daniel.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.daniel.api.entities.ServerEntity;
import com.daniel.api.useCases.ServerUseCase;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Server;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/create")
public class CreateServer {

    @Autowired
    ServerUseCase serverUseCase;

    @PostMapping("/server")
    public ResponseEntity postMethodName(@RequestBody ServerEntity entity) {

                try{

                    ServerEntity execute = serverUseCase.execute(entity);

                    return ResponseEntity.ok().body(execute);

                }catch (Exception e){

                    return ResponseEntity.badRequest().body(e.getMessage());

                }
        
        
    }
    
    
}
