package com.chuwa.xhs.service.Impl;

import com.chuwa.xhs.dao.PostRepository;
import com.chuwa.xhs.entity.Post;
import com.chuwa.xhs.exception.ResourceNotFoundException;
import com.chuwa.xhs.payload.PostDto;
import com.chuwa.xhs.service.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    //constructor injection
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        //step 1: create object "Post"
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
//        post.setMetaData("metaData");

        //step 2: connect to DB and save object "Post"
        Post savedPost = postRepository.save(post);

        return transferPostToPostDto(savedPost);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(post -> transferPostToPostDto(post)).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public PostDto updatePost(PostDto newPostDto, long postId) {
        //step-1: retrieve the oldPost
        Post oldPost = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        //step-2: update the oldPost with newPostDto
        oldPost.setTitle(newPostDto.getTitle());
        oldPost.setContent(newPostDto.getContent());
        oldPost.setDescription(newPostDto.getDescription());
        postRepository.save(oldPost);

        //step-3: return
        return transferPostToPostDto(oldPost);
    }

    @Override
    public PostDto getPostById(long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        return transferPostToPostDto(post);
    }

    @Override
    public PostDto deletePost(long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        postRepository.delete(post);
        return transferPostToPostDto(post);

    }


    private PostDto transferPostToPostDto(Post post) {
        PostDto response = new PostDto();
        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setContent(post.getContent());
        response.setDescription(post.getDescription());

        return response;
    }
}
