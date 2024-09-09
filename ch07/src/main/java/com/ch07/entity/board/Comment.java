package com.ch07.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

// Entity는 @Setter 안씀 보안상 좋지 않음
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity                 // 엔티티 객체 정의
@Table(name = "board_comment")    // 매핑 테이블 설정
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    private String content;

    @CreationTimestamp
    private LocalDateTime rdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent")
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer")
    private User user;
}
