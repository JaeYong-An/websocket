package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    // 추가적인 메시지 검색이나 조작을 위한 메소드 작성
}