package com.ll.elk.domain.post.postDoc.service;

import com.ll.elk.domain.post.postDoc.document.PostDoc;
import com.ll.elk.domain.post.postDoc.repository.PostDocRepository;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostDocService {
    private final PostDocRepository postDocRepository;

    public PostDoc write(String title, String content) {
        PostDoc postDoc = PostDoc.builder()
                .title(title)
                .content(content)
                .build();
        return postDocRepository.save(postDoc);
    }

    public void truncate() {
        postDocRepository.deleteAll();
    }

    public List<PostDoc> getItemByName(String keyword) {
        List<PostDoc> byName = postDocRepository.findByTitle(keyword);
        return byName;
    }
}

