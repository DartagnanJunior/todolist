package com.study.todolist.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name="tb_users")
public class UsersModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID userId;
    private String userName;
    private String name;
    private String password;
    private String email;
    private Double document;
    @CreationTimestamp
    private LocalDateTime creationDate;
}
