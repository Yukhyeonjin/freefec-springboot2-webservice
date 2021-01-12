package com.yuk.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 클래스 내의 모든 필드 Get 함수 자동 생성
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity // 테이블과 링크될 클래스
public class Posts {

    @Id // 해당 필드의 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙, GenerationType.IDENTITY을 추가 해야만 auto_increment된다.
    private Long id;

    @Column(length = 500, nullable = false) // 컬럼 선언
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // 컬럼 선언
    private String content;
    
    // @Column을 선언하지 않아도 클래스 내의 필드는 모두 컬럼 선언하는 이유는 옵션을 주기 위함
    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성, 생성자에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
