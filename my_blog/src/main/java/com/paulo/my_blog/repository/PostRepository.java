package com.paulo.my_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulo.my_blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    
}
