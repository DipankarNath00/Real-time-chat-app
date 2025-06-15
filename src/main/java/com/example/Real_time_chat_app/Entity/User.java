package com.example.Real_time_chat_app.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    private String hashPassword;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String displayName;

}
