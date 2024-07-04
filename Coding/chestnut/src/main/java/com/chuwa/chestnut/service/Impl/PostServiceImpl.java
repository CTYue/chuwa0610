package com.chuwa.chestnut.service.Impl;

import com.chuwa.chestnut.dao.PostRepository;
import com.chuwa.chestnut.entity.Post;
import com.chuwa.chestnut.exception.ResourceNotFoundException;
import com.chuwa.chestnut.payload.PostDto;
import com.chuwa.chestnut.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        // create object Post
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post savedPost = postRepository.save(post);

        return transferPostToPostDto(savedPost);
    }

    private PostDto transferPostToPostDto(Post post) {

        PostDto response = new PostDto();
        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setContent(post.getContent());
        response.setDescription(post.getDescription());

        return response;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(post ->
                transferPostToPostDto(post)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() ->
            new ResourceNotFoundException("Post", "id", postId));
        return transferPostToPostDto(post);
    }

    @Override
    public PostDto updatePost(PostDto newPostDto, Long id) {
        // step1 retrieve the old post
        Post oldPost = postRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Post", "id", id));
        oldPost.setTitle(newPostDto.getTitle());
        oldPost.setContent(newPostDto.getContent());
        oldPost.setDescription(newPostDto.getDescription());
        postRepository.save(oldPost);

        // step2 update the old post with new postDto
        return transferPostToPostDto(oldPost);
    }

    @Override
    public boolean deletePost(PostDto postDto, Long id) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
        return true;
    }


}
