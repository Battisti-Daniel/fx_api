package com.daniel.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "servers")
@Data
public class ServerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servers_id_seq")
    @SequenceGenerator(name = "servers_id_seq", sequenceName = "servers_id_seq", allocationSize = 1)
    private int id;

    private String name;
    private String ip;
    private String status;

    
}
