package org.example.dtoPractice.controller.viewmodel;

import lombok.Builder;
import lombok.Getter;

public class PostsViewModel {

    @Getter
    @Builder
    public static class postsSave{
        String result;
        String title;
        String content;
        String author;
    }

    @Getter
    @Builder
    public static class postsUpdate{
        String result;
        String title;
        String content;
    }

}
