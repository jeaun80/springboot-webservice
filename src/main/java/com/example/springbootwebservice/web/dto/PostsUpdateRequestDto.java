package com.example.springbootwebservice.web.dto;

import com.example.springbootwebservice.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Builder
public class PostsUpdateRequestDto {

    private String content;
    private String title;


    public PostsUpdateRequestDto(Posts entity){
        this.content=entity.getContent();
        this.title=entity.getTitle();
    }

}
