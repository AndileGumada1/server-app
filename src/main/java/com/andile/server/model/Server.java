package com.andile.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server implements Serializable{
    
 @Id @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 @Column(unique = true)
 @NotEmpty(message = "IP Address can not be empty or null")
 private String ipAddress;
 private String name;  
 private String memory;  
 private String type;  
 private String imageUrl;
 private Status status;       
}
