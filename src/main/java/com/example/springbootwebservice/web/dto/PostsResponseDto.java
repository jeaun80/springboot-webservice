package com.example.springbootwebservice.web.dto;


import com.example.springbootwebservice.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String content;
    private String title;
    private String author;

    public PostsResponseDto(Posts Entity){
        this.id=Entity.getId();
        this.content=Entity.getContent();
        this.author=Entity.getAuthor();
        this.title=Entity.getTitle();
    }
}
