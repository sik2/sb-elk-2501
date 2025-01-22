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

    public PostDoc write( String title, String content) {
        PostDoc postDoc = PostDoc.builder()
                .title(title)
                .content(content)
                .build();
        return postDocRepository.save(postDoc);
    }

    public void truncate() {
        postDocRepository.deleteAll();
    }

    public List<PostDoc> findByTitle(String keyword) {
        return postDocRepository.searchByKeyword(keyword);
    }

    public void testSearch(String keyword) {
        List<PostDoc> results = postDocRepository.searchByKeyword(keyword);
        
        System.out.println("검색어: " + keyword);
        System.out.println("검색 결과 수: " + results.size());
        
        results.forEach(doc -> {
            System.out.println("제목: " + doc.getTitle());
            System.out.println("내용: " + doc.getContent());
            System.out.println("-------------------");
        });
    }
}

