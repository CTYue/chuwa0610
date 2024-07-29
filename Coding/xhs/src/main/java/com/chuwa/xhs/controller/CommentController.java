package com.chuwa.xhs.controller;

import com.chuwa.xhs.payload.CommentDto;
import com.chuwa.xhs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.validation.annotation.Validated;


@RestController
@RequestMapping("/api/v1")
public class CommentController {
    /**
     * TODO: Questions
     * why intellij give us this warning? constructor injection.
     * IntelliJ often promotes constructor injection over field or setter injection because it encourages immutability and ensures that required dependencies are not null.
     *
     * how many ways we can do Dependency Injection?
     * Constructor Injection: Dependencies are provided through the class constructor.
     * Setter Injection: Dependencies are set through JavaBean-style setter methods.
     * Field Injection: Dependencies are injected directly into the fields of a class using annotations like @Autowired.
     *
     * which way is the best one?
     * Constructor injection is generally recommended for most cases due to its advantages in terms of immutability, ease of testing, and clear dependency indication. It helps ensure that your beans are always in a valid state once instantiated.
     */
    @Autowired
    private CommentService commentService;

    /**
     * TODO: Questions
     * 当我们浏览小红书时候，点开一篇文章，请问获得这篇文章的内容，是用的哪个API？ getCommentsByPostId
     * 看到大家争论库里历史地位是否超越科比，你要写评论回应，当你的评论提交时候，会call哪个API？ createComment
     * <p>
     * 此时此刻，思考为什么post的ID是pathVariable 而不是request parameter? always needed
     *
     * @param id
     * @param commentDto
     * @return
     */
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long id,
                                                    @Validated @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.createComment(id, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") Long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentsById(
            @PathVariable(value = "postId") Long postId,
            @PathVariable(value = "id") Long commentId) {

        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable(value = "postId") Long postId,
                                                    @PathVariable(value = "id") Long commentId,
                                                    @Validated @RequestBody CommentDto commentDto) {
        CommentDto updateComment = commentService.updateComment(postId, commentId, commentDto);
        return new ResponseEntity<>(updateComment, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long postId,
                                                @PathVariable(value = "id") Long commentId) {
        commentService.deleteComment(postId, commentId);

        return new ResponseEntity<>("Comment deleted Successfully", HttpStatus.OK);
    }
}
