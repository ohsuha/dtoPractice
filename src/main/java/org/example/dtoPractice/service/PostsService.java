package org.example.dtoPractice.service;

import lombok.RequiredArgsConstructor;
import org.example.dtoPractice.domain.model.Posts;
import org.example.dtoPractice.domain.repository.PostsRepository;
import org.example.dtoPractice.controller.request.PostsResponseDto;
import org.example.dtoPractice.controller.request.PostsSaveRequestDto;
import org.example.dtoPractice.controller.request.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public long update(long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id : "+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public PostsResponseDto findById(long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id : "+id));

        return new PostsResponseDto(entity);
    }
}
