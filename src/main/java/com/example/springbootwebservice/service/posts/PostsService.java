package com.example.springbootwebservice.service.posts;

import com.example.springbootwebservice.domain.posts.Posts;
import com.example.springbootwebservice.domain.posts.PostsRepository;
import com.example.springbootwebservice.web.dto.PostsResponseDto;
import com.example.springbootwebservice.web.dto.PostsSaveRequestDto;
import com.example.springbootwebservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;


    @Transactional
    public Long save(PostsSaveRequestDto postsSaveRequestDto){
        return postsRepository.save(postsSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(PostsUpdateRequestDto postsUpdateRequestDto,Long id){
        Posts posts=postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당게시글이 없습니다."));
        posts.update(postsUpdateRequestDto.getTitle(),postsUpdateRequestDto.getContent());
        return id;
    }


    @Transactional
    public PostsResponseDto findById(Long id){
        Posts entity=postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("그런아이디 없습니다."));
        return new PostsResponseDto(entity);
    }
}
