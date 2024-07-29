package com.chuwa.redbook.Service.Impl;

import com.chuwa.redbook.Service.PostService;
import com.chuwa.redbook.dao.PostRepository;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.exception.UniqueConstraintViolationException;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.payload.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class PostServiceImpl implements PostService {

    @Autowired
    public PostRepository postRepository;

//    @Autowired// constructer Injection
//    public PostServiceImpl(PostRepository postRepository) {
//        this.postRepository = postRepository;
//    }
    @Override
    public PostDto createPost(PostDto postDto) {
//        try {
//            // Step 1: Create object "Post"
//            Post post = new Post();
//            post.setTitle(postDto.getTitle());
//            post.setContent(postDto.getContent());
//            post.setDescription(postDto.getDescription());
//
//            // Step 2: Connect to DB and save object "Post"
//            Post savedPost = postRepository.save(post);
//            return transferPostToPostDto(savedPost);
//        } catch (DataIntegrityViolationException ex) {
//            // Extract details from the exception using static methods
//            String duplicateField = UniqueConstraintViolationException.extractDuplicateFieldFromException(ex);
//            String duplicateValue = UniqueConstraintViolationException.extractDuplicateValueFromException(ex);
//            throw new UniqueConstraintViolationException(duplicateField, duplicateValue);
//        }
        try {
            // Convert DTO to Entity
            Post post = mapToEntity(postDto);

            // Save the Post entity to the database
            Post savedPost = postRepository.save(post);

            // Convert the saved Post entity back to DTO
            return mapToDTO(savedPost);
        } catch (DataIntegrityViolationException ex) {
            // Extract details from the exception using static methods
            String duplicateField = UniqueConstraintViolationException.extractDuplicateFieldFromException(ex);
            String duplicateValue = UniqueConstraintViolationException.extractDuplicateValueFromException(ex);
            throw new UniqueConstraintViolationException(duplicateField, duplicateValue);
        }
    }

    // Helper methods to extract field name and value from the exception


    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = posts.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        return mapToDTO(post);
    }

    @Override
    public PostDto updatePost(PostDto newPostDto, Long postId) {
        //step1: retrieve old post
        Post oldPost = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        //step2; update old PostDto with new postDto
        oldPost.setTitle(newPostDto.getTitle());
        oldPost.setContent(newPostDto.getContent());
        oldPost.setDescription(newPostDto.getDescription());
        Post updatedPost = postRepository.save(oldPost);
        //step3: return
        return mapToDTO(updatedPost);
    }

    @Override
    public PostDto deletePost(Long postId) {
        //step1 retrieve postId
        Post deletePost = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        //step2. delete the post
        postRepository.delete(deletePost);
        //step3 return the deleted post as PostDto
        return mapToDTO(deletePost);
    }


//    private PostDto transferPostToPostDto(Post post) {
//        PostDto response = new PostDto();
//        response.setId(post.getId());
//        response.setTitle(post.getTitle());
//        response.setContent(post.getContent());
//        response.setDescription(post.getDescription());
//        return response;
//    }

    @Override
    public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts.stream().map(this::mapToDTO).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContents(postDtos);
        postResponse.setPageNo(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLast(pagePosts.isLast());
        return postResponse;
    }

    private PostDto mapToDTO(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setDescription(post.getDescription());
        return postDto;
    }

    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        return post;
    }

}
