package com.example.xhs.service.Impl;

import com.example.xhs.dao.PostRepository;
import com.example.xhs.entity.Post;
import com.example.xhs.exception.ResourceNotFoundException;
import com.example.xhs.payload.PostDto;
import com.example.xhs.payload.PostResponse;
import com.example.xhs.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {


    //constructor injection
//    private PostRepository postRepository;
//    public PostServiceImpl(PostRepository postRepository) {
//        this.postRepository = postRepository;
//    }
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto) {
//        //step 1: create object "Post"
//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setContent(postDto.getContent());
//        post.setDescription(postDto.getDescription());
////        post.setMetaData("metaData");
//
//        //step 2: connect to DB and save object "Post"
//        Post savedPost = postRepository.save(post);
//
//        return transferPostToPostDto(savedPost);
        Post post = modelMapper.map(postDto, Post.class);
        Post savedPost = postRepository.save(post);
        return modelMapper.map(savedPost, PostDto.class);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
//        List<PostDto> postDtos = posts.stream().map(post -> transferPostToPostDto(post)).collect(Collectors.toList());
        List<PostDto> postDtos = posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
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
    public void deletePostById(long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", String.valueOf(postId), postId));
        postRepository.deleteById(postId);

    }

    @Override
    public PostDto getPostByTitle(String title) {

        return transferPostToPostDto(postRepository.findByTitle(title));
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
    public PostDto getPostById(long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
//        postRepository.findByAge(20);
        return modelMapper.map(post, PostDto.class);
//        return transferPostToPostDto(post);
    }


    private PostDto transferPostToPostDto(Post post) {
        PostDto response = new PostDto();
        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setContent(post.getContent());
        response.setDescription(post.getDescription());
//        response.setComments(post.getComments());

        return response;
    }

    // practice
    @Override
    public List<PostDto> getAllPostSort(int page, int size, String sort, String order) {
        List<Post> ans = postRepository.findAll();
        return ans.stream().map(this::transferPostToPostDto).toList();
    }

    @Override
    public List<PostDto> getPostLimit() {
        List<Post> posts = postRepository.findTop2ByOrderByTitleDesc();
        List<PostDto> postDtos = posts.stream().map(post -> transferPostToPostDto(post)).collect(Collectors.toList());

        return postDtos;
    }

}
