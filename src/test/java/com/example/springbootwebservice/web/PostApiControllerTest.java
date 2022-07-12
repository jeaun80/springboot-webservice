package com.example.springbootwebservice.web;

import com.example.springbootwebservice.domain.posts.Posts;
import com.example.springbootwebservice.domain.posts.PostsRepository;
import com.example.springbootwebservice.web.dto.PostsUpdateRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostApiControllerTest {

    @Autowired
    private PostsRepository postsRepository;


    private TestRestTemplate restTemplate;

    @Test
    public void post_modi(){

        Posts savedPosts = postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        Long updateId = savedPosts.getId();
        String updateTitle ="updatetitle";
        String uqdatecontent="updatecontent";


        PostsUpdateRequestDto postsUpdateRequestDto = PostsUpdateRequestDto.builder()
                .title(updateTitle)
                .content(uqdatecontent)
                .build();
        String port="8080";
        String url = "http://localhost:"+port+"/api/v1/posts/"+updateId;


        HttpEntity<PostsUpdateRequestDto> requestEntity= new HttpEntity<>(postsUpdateRequestDto);

        ResponseEntity<Long> responseEntity = restTemplate.
                exchange(url, HttpMethod.PUT,requestEntity,Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();

        //jpa를 사용하는 컨트롤러 테스트 의 경우
        //1. 업데이트
        //기본적인 객체 만들어서 데이터베이스에 저장
        //업데이트할 정보 dto로 만들기
        //컨트롤러에서 업데이트함수의 url 넣기(url, curd메소드, 업데이트dto로 만든 httpEntity, long?)
        //assertThat으로 검사(상태코드, 바디가 잇나없나)
        //레파지토리에서 파인드 해서 검사
        //assertThat으로 넣은거 필드 부합하는지 검사.
        //
        //
        //

    }

}
