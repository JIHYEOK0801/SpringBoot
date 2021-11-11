package com.example.SpringBoot.domain.posts;

import com.example.SpringBoot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity // JPA annotation. 테이블과 링크될 클래스를 나타냄
public class Posts extends BaseTimeEntity {
    @Id // 테이블의 PK를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK생성 규칙
    private Long id;

    @Column(length = 500, nullable = false) // 테이블 컬럼. 굳이 나타내지 않아도 필드는 모두 컬럼이 됨
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
