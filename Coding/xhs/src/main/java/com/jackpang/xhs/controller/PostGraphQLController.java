package com.jackpang.xhs.controller;

import com.jackpang.xhs.payload.PostDto;
import com.jackpang.xhs.payload.PostResponse;
import com.jackpang.xhs.service.PostService;
import com.jackpang.xhs.util.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * description: PostGraphQLController
 * date: 7/1/24 10:09 PM
 * author: jinhao_pang
 * version: 1.0
 */
@Controller
@RequiredArgsConstructor
public class PostGraphQLController {
    private final PostService postService;

    @QueryMapping
    public PostDto getById(@Argument Long id) {
        return postService.getPostById(id);
    }

    @QueryMapping
    public PostResponse getAllPosts(@Argument Integer pageNo,
                                    @Argument Integer pageSize,
                                    @Argument String sortBy,
                                    @Argument String sortDir) {
        int pageNoOrDefault = (pageNo != null) ? pageNo : Integer.parseInt(AppConstants.DEFAULT_PAGE_NUMBER);
        int pageSizeOrDefault = (pageSize != null) ? pageSize : Integer.parseInt(AppConstants.DEFAULT_PAGE_SIZE);
        String sortByOrDefault = (sortBy != null) ? sortBy : AppConstants.DEFAULT_SORT_BY;
        String sortDirOrDefault = (sortDir != null) ? sortDir : AppConstants.DEFAULT_SORT_DIR;
        return postService.getAllPost(pageNoOrDefault, pageSizeOrDefault, sortByOrDefault, sortDirOrDefault);
    }

    @MutationMapping
    public PostDto createPost(@Argument String title, @Argument String content, @Argument String description) {
        PostDto postDto = new PostDto();
        postDto.setTitle(title);
        postDto.setContent(content);
        postDto.setDescription(description);
        return postService.createPost(postDto);
    }

    @MutationMapping
    public PostDto deleteById(@Argument Long id) {
        return postService.deleteById(id);
    }
}
