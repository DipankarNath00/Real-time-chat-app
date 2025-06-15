package com.example.Real_time_chat_app.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor // Added for JPA and Lombok
@AllArgsConstructor // Added for Lombok, useful for testing
@Table(name = "group_chats")
public class GroupChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "admin_id",nullable = false)
    private User admin;
    @ManyToMany
    @JoinTable(
            name = "group_chat_members", // Name of the join table
            joinColumns = @JoinColumn(name = "group_chat_id"), // Column in join table referring to GroupChat
            inverseJoinColumns = @JoinColumn(name = "user_id") // Column in join table referring to User
    )
    private Set<User> members= new HashSet<>();
    // Optional: Add a helper method to easily add members
    public void addMember(User user) {
        this.members.add(user);
        // If User also has a @ManyToMany relationship back to GroupChat, you'd add:
        // user.getGroupChats().add(this); // (assuming a getGroupChats() method exists on User)
    }

    public void removeMember(User user) {
        this.members.remove(user);
        // If a User also has a @ManyToMany relationship back to GroupChat, you'd add:
        // user.getGroupChats().remove(this);
    }
}
