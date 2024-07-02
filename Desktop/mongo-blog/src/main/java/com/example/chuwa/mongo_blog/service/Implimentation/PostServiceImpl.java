package com.example.chuwa.mongo_blog.service.Implimentation;

import com.example.chuwa.mongo_blog.dao.PostRepository;
import com.example.chuwa.mongo_blog.entity.Post;
import com.example.chuwa.mongo_blog.payload.PostDto;
import com.example.chuwa.mongo_blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    // inject postRepository object
    @Autowired
    private  PostRepository postRepository;


    @Override
    public PostDto createPost(PostDto postDto) {
        //step 1: create object "Post"
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        //step 2: connect to DB and save object "Post"
        System.out.println("sssssssssssssssss");
        Post savedPost = postRepository.save(post);
        PostDto response = new PostDto();
        response.setId(savedPost.getId());
        response.setTitle(savedPost.getTitle());
        response.setContent(savedPost.getContent());
        response.setDescription(savedPost.getDescription());

        return response;
    }
}
