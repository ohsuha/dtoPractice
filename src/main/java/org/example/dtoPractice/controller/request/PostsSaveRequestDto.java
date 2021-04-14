package org.example.dtoPractice.controller.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.dtoPractice.domain.model.Posts;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    @NotBlank(message = "title is required")
    private String title;

    @NotBlank(message = "content is required")
    private String content;

    @NotBlank(message = "author is required")
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Posts toEntity(){
        return Posts.builder()
                .author(author)
                .title(title)
                .content(content)
                .build();
    }

    @Override
    public String toString() {
        return "PostsSaveRequestDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
