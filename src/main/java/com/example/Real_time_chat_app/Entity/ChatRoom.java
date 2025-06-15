package com.example.Real_time_chat_app.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "chat_rooms")
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user1_id", nullable = false) // 'user1_id' will be the foreign key column in chat_rooms table
    private User user1;
    @ManyToOne
    @JoinColumn(name = "user2_id", nullable = false)
    private User user2;
}
