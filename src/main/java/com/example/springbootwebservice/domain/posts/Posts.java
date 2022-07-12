package com.example.springbootwebservice.domain.posts;


import com.example.springbootwebservice.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 500,nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title,String content,String author){
        this.title=title;
        this.author=author;
        this.content=content;
    }
    public void update(String title,String content){
        this.title=title;
        this.content=content;
    }
}
