package org.example.dtoPractice.domain.repository;

import org.example.dtoPractice.domain.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
