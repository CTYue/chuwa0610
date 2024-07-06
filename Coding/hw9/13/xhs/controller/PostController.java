package com.example.xhs.controller;

import com.example.xhs.entity.Post;
import com.example.xhs.exception.ResourceNotFoundException;
import com.example.xhs.payload.PostDto;
import com.example.xhs.service.PostService;
import com.example.xhs.util.AppConstrants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto response = postService.createPost(postDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<List<PostDto>> getAllPosts() {
//        return ResponseEntity.ok(postService.getAllPost());
//    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(
            @RequestParam(name = "pageNo", defaultValue = AppConstrants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstrants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstrants.DEFAULT_SORT_DIR, required = false) String sortDir
    ) {
        List<PostDto> list = postService.getAllPost();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/limit")
    public ResponseEntity<List<PostDto>> getAllPostsLimit() {

        return ResponseEntity.ok(postService.getPostLimit());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name = "id") Long id) {
        PostDto updatedDto = postService.updatePost(postDto,id);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByID(@PathVariable("id") Long id) {

        try {
            postService.deletePostById(id);

            return ResponseEntity.ok("delete sucessfully");
        } catch (ResourceNotFoundException e) {
            System.out.println("not found");
//            e.printStackTrace();
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        } catch (Exception e ) {
            System.out.println("other issue");
//            e.printStackTrace();
            return new ResponseEntity<>("other issue", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{title}")
    public ResponseEntity<PostDto> getPostByTitle(@PathVariable( "title") String title) {
        return new ResponseEntity<>(postService.getPostByTitle(title), HttpStatus.OK);
    }
}
