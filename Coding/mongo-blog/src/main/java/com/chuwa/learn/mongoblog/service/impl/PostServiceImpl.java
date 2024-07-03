package com.chuwa.learn.mongoblog.service.impl;

import com.chuwa.learn.mongoblog.entity.Post;
import com.chuwa.learn.mongoblog.repository.PostRepository;
import com.chuwa.learn.mongoblog.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }
}
