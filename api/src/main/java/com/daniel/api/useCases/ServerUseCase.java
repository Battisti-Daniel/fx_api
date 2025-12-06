package com.daniel.api.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.api.entities.ServerEntity;
import com.daniel.api.repositories.ServerRepository;

@Service
public class ServerUseCase {

    @Autowired
    ServerRepository serverRepository;

    public ServerEntity execute(ServerEntity server) {

        serverRepository.findByName(server.getName()).ifPresent(
            serverEntity -> {
                throw new RuntimeException("Já existe um servidor com esse nome");
            }
        );

        return serverRepository.save(server);
    

    }
    
}
