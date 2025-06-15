package com.example.Real_time_chat_app.Repository;

import com.example.Real_time_chat_app.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findByGroupChatIdOrderByTimestampAsc(Long groupChatId);
    List<Message> findByReceiverIdOrderByTimestampAsc(Long chatRoomId);
}
