package com.ll.elk.domain.post.post.service;

import com.ll.elk.domain.post.post.entity.Post;
import com.ll.elk.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void write(String title, String content) {
        Post post = Post.builder()
                .title(title)
                .content(content)
                .build();

        postRepository.save(post);
    }

    public void deleteAll() {
        postRepository.deleteAll();
    }
}
