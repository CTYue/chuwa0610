package com.jackpang.xhs.service.impl;

import com.jackpang.xhs.dao.PostRepository;
import com.jackpang.xhs.entity.Post;
import com.jackpang.xhs.exception.ResourceNotFoundException;
import com.jackpang.xhs.payload.PostDto;
import com.jackpang.xhs.payload.PostResponse;
import com.jackpang.xhs.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * description: PostServiceImpl
 * date: 6/28/24 10:11 PM
 * author: jinhao_pang
 * version: 1.0
 */
@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        Post savedPost = postRepository.save(post);
        return modelMapper.map(savedPost, PostDto.class);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }


    @Override
    public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create pageable instance

        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
//        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        // get content for page abject
        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNo(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLast(pagePosts.isLast());
        return postResponse;
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto newPostDto, Long id) {
        Post oldPost = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        oldPost.setTitle(newPostDto.getTitle());
        oldPost.setContent(newPostDto.getContent());
        oldPost.setDescription(newPostDto.getDescription());
        postRepository.save(oldPost);
        return modelMapper.map(oldPost, PostDto.class);
    }

    @Override
    public PostDto deleteById(Long id) {
        Post oldPost = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.deleteById(id);
        return modelMapper.map(oldPost, PostDto.class);
    }

}
