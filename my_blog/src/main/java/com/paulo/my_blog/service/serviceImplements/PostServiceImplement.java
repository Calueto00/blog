package com.paulo.my_blog.service.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.paulo.my_blog.model.Post;
import com.paulo.my_blog.repository.PostRepository;
import com.paulo.my_blog.service.PostService;


public class PostServiceImplement implements PostService{

    @Autowired
    private PostRepository pr;

    @Override
    public List<Post> findAll() {
        return pr.findAll();
    }

    @Override
    public Post findById(long id) {
        return pr.findById(id).get();
    }

    @Override
    public Post save(Post post) {
       return pr.save(post);
    }
    
}
