//package com.chuwa.mongoblog.controller;
//
//
//import com.chuwa.mongoblog.dto.PostDto;
//import com.chuwa.mongoblog.service.PostService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("api/v1/posts")
//public class PostController {
//
//    @Autowired
////    @Qualifier("")
//    private PostService postService;
//
//    @PostMapping(value = "create")
//    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
//        PostDto response = postService.createPost(postDto);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//
////    @PostMapping(value = "create")
////    public PostDto createPost(@RequestParam(value = "id", required = true) Long id,
////                              @RequestParam(value = "title") String title,
////                              @RequestParam(value = "content") String content,
////                              @RequestParam(value = "description") String description) {
////        PostDto postDto = new PostDto();
////        postDto.setId(id);
////        postDto.setTitle(title);
////        postDto.setContent(content);
////        postDto.setDescription(description);
////        PostDto response = postService.createPost(postDto);
////        return response;
////    }
//
//    /**
//     * @PathVariable
//     * 用于获取URL路径中的动态部分。示例URL：/posts/123
//     * @param id
//     * @return
//     */
//
////    @GetMapping(value = "")
//    @GetMapping
//    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) {
//        PostDto response = postService.getPostById(id);
//        return ResponseEntity.ok(response);
//    }
//
//    /**
//     * @RequestParam
//     * 用于获取URL查询字符串中的参数。示例URL：/posts?category=tech
//     */
//}
