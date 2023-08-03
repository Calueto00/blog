package com.paulo.my_blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paulo.my_blog.model.Post;
@Service
public interface PostService {

    List<Post>findAll();

    Post findById(long id);

    Post save(Post post);
}
