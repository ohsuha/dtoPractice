package org.example.dtoPractice.controller.request;

import lombok.Getter;
import org.example.dtoPractice.domain.model.Posts;

import java.time.LocalDateTime;

@Getter
public class PostsDetails {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;

    //Entity의 일부만 사용하므로 생성자로 enttiy를 받아 필드에 값을 넣습니다.
    public PostsDetails(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.createTime = entity.getCreatedDate();
        this.modifiedTime = entity.getModifiedDate();
    }
}
