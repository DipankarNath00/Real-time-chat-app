package com.example.Real_time_chat_app.Repository;

import com.example.Real_time_chat_app.Entity.GroupChat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupChatRepository extends JpaRepository<GroupChat,Long> {
}
