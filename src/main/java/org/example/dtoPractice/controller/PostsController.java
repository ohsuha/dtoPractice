package org.example.dtoPractice.controller;

import lombok.RequiredArgsConstructor;
import org.example.dtoPractice.controller.viewmodel.PostsViewModel;
import org.example.dtoPractice.service.PostsService;
import org.example.dtoPractice.controller.request.PostsResponseDto;
import org.example.dtoPractice.controller.request.PostsSaveRequestDto;
import org.example.dtoPractice.controller.request.PostsUpdateRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public ResponseEntity<PostsViewModel.postsSave> save(@RequestBody PostsSaveRequestDto requestDto){
        postsService.save(requestDto);

        PostsViewModel.postsSave result = PostsViewModel.postsSave.builder()
                                            .result("ok")
                                            .title(requestDto.getTitle())
                                            .author(requestDto.getAuthor())
                                            .content(requestDto.getContent())
                                            .build();
        ResponseEntity<PostsViewModel.postsSave> response = new ResponseEntity<>(result, HttpStatus.OK);

        return response;
    }

    @PutMapping("/api/v1/posts/{id}")
    public ResponseEntity<PostsViewModel.postsUpdate> update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        postsService.update(id, requestDto);

        PostsViewModel.postsUpdate result = PostsViewModel.postsUpdate.builder()
                                            .result("ok")
                                            .content(requestDto.getContent())
                                            .title(requestDto.getTitle())
                                            .build();

        ResponseEntity<PostsViewModel.postsUpdate> response = new ResponseEntity<>(result, HttpStatus.OK);
        return response;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
