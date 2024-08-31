package com.chuwa.learn.mysqlblog.controller;


import com.chuwa.learn.mysqlblog.payload.CommentDTO;
import com.chuwa.learn.mysqlblog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/posts")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/{blogId}/comments")
    public ResponseEntity<CommentDTO> createComment(@PathVariable(value = "blogId") long id, @RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(commentService.createComment(id, commentDTO), HttpStatus.CREATED);
    }

//    @GetMapping("/posts/{postId}/comments")
//    public ResponseEntity<CommentDTO> getCommentsByBlogId(){}

}
