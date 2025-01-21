package com.ll.elk.domain.post.post.repository;

import com.ll.elk.domain.post.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post, Long> {
}
