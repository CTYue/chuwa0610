package com.jackpang.xhs.service.impl;

import com.jackpang.xhs.dao.PostRepository;
import com.jackpang.xhs.entity.Post;
import com.jackpang.xhs.exception.ResourceNotFoundException;
import com.jackpang.xhs.payload.PostDto;
import com.jackpang.xhs.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * description: PostServiceImpl
 * date: 6/28/24 10:11 PM
 * author: jinhao_pang
 * version: 1.0
 */

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {

        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post savedPost = postRepository.save(post);

        return transferPostToPostDto(savedPost);
    }

    private PostDto transferPostToPostDto(Post savedPost) {

        PostDto response = new PostDto();
        response.setId(savedPost.getId());
        response.setTitle(savedPost.getTitle());
        response.setContent(savedPost.getContent());
        response.setDescription(savedPost.getDescription());
        return response;
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::transferPostToPostDto).toList();
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return transferPostToPostDto(post);
    }

    @Override
    public PostDto updatePost(PostDto newPostDto, Long id) {
        Post oldPost = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        oldPost.setTitle(newPostDto.getTitle());
        oldPost.setContent(newPostDto.getContent());
        oldPost.setDescription(newPostDto.getDescription());
        postRepository.save(oldPost);
        return transferPostToPostDto(oldPost);
    }

    @Override
    public PostDto deleteById(Long id) {
        Post oldPost = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.deleteById(id);
        return transferPostToPostDto(oldPost);
    }
}
