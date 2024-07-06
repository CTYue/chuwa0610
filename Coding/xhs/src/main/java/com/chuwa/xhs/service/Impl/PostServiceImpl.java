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
        Post post = transferPostDtoToPost(postDto);

        //step 2: connect to DB and save object "Post"
        // 调用Dao的save 方法，将entity的数据存储到数据库MySQL
        // save()会返回存储在数据库中的数据
        Post savedPost = postRepository.save(post);
        // 将save() 返回的数据转换成controller/前端 需要的数据，然后return给controller
        PostDto postResponse = transferPostToPostDto(savedPost);
        return postResponse;
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = posts.stream().map(post -> transferPostToPostDto(post)).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create pageable instance

        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        // get content for page abject
        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts.stream().map(post -> transferPostToPostDto(post)).collect(Collectors.toList());

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

        return transferPostToPostDto(post);
    }


    @Override
    public PostDto updatePost(PostDto newPostDto, long postId) {
        //step-1: retrieve the oldPost
        Post oldPost = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        //step-2: update the oldPost with newPostDto
        oldPost.setTitle(newPostDto.getTitle());
        oldPost.setContent(newPostDto.getContent());
        oldPost.setDescription(newPostDto.getDescription());
        Post updatePost = postRepository.save(oldPost);

        //step-3: return
        return transferPostToPostDto(updatePost);
    }

    @Override
    public void deletePostById(long postId) {

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }


    private PostDto transferPostToPostDto(Post post) {
        PostDto response = new PostDto();
        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setContent(post.getContent());
        response.setDescription(post.getDescription());

        return response;
    }

    private Post transferPostDtoToPost(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }
}
