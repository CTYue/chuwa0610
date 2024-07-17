package com.jackpang.xhs.controller;

import com.jackpang.xhs.payload.PostDto;
import com.jackpang.xhs.payload.PostResponse;
import com.jackpang.xhs.service.PostService;
import com.jackpang.xhs.util.AppConstants;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description: PostController
 * date: 6/28/24 10:21 PM
 * author: jinhao_pang
 * version: 1.0
 */
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
        PostDto response = postService.createPost(postDto);
//        return ResponseEntity.ok(response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN, USER')")
    @GetMapping
    public PostResponse getAllPosts(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) Integer pageNo,
                                    @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) Integer pageSize,
                                    @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
                                    @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir
    ) {
        return postService.getAllPost(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@Valid @RequestBody PostDto postDto, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(postService.updatePost(postDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
        postService.deleteById(id);
        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }
}
