package com.example.springbootwebservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostsRepository extends JpaRepository<Posts,Long> {

}
