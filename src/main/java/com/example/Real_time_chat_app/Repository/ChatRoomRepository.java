package com.example.Real_time_chat_app.Repository;

import com.example.Real_time_chat_app.Entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom,Long> {
    Optional<ChatRoom> findByUser1IdAndUser2Id(Long user1Id, Long user2Id);
}
