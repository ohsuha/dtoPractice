package org.example.dtoPractice.controller;

import lombok.RequiredArgsConstructor;
import org.example.dtoPractice.controller.request.PostsDetails;
import org.example.dtoPractice.controller.request.PostsSaveRequest;
import org.example.dtoPractice.controller.response.PostsResponse;
import org.example.dtoPractice.service.PostsService;
import org.example.dtoPractice.controller.request.PostsUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class PostsController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public ResponseEntity<PostsResponse.postsSave> save(@Valid @RequestBody PostsSaveRequest requestDto){
        postsService.save(requestDto);

        PostsResponse.postsSave result = PostsResponse.postsSave.builder()
                                            .result("ok")
                                            .title(requestDto.getTitle())
                                            .author(requestDto.getAuthor())
                                            .content(requestDto.getContent())
                                            .build();
        ResponseEntity<PostsResponse.postsSave> response = new ResponseEntity<>(result, HttpStatus.OK);

        return response;
    }

    @PutMapping("/api/v1/posts/{id}")
    public ResponseEntity<PostsResponse.postsUpdate> update(@Valid @PathVariable Long id, @RequestBody PostsUpdateRequest requestDto){
        postsService.update(id, requestDto);

        PostsResponse.postsUpdate result = PostsResponse.postsUpdate.builder()
                                            .result("ok")
                                            .content(requestDto.getContent())
                                            .title(requestDto.getTitle())
                                            .build();

        ResponseEntity<PostsResponse.postsUpdate> response = new ResponseEntity<>(result, HttpStatus.OK);
        return response;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsDetails findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
