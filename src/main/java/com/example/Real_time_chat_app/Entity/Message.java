package com.example.Real_time_chat_app.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String content;
    private LocalDateTime timestamp;
    @ManyToOne
    private User sender;
    @ManyToOne
    private ChatRoom receiver;
    @ManyToOne
    private GroupChat groupChat;
}
