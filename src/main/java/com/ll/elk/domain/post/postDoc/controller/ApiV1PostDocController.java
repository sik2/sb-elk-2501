package com.ll.elk.domain.post.postDoc.controller;

import com.ll.elk.domain.post.postDoc.document.PostDoc;
import com.ll.elk.domain.post.postDoc.service.PostDocService;
import com.ll.elk.global.rsData.RsData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/postDocs")
@RestController
@RequiredArgsConstructor
public class ApiV1PostDocController {
    private final PostDocService postDocService;

    @GetMapping("/search")
    public List<PostDoc> search(@RequestParam("keyword") String keyword) {
        return  postDocService.getItemByName(keyword);
    }

    record PostDocRequest (
        @NotBlank
        String title,
        @NotBlank
        String content
    ) {}

    @PostMapping("/write")
    public RsData<PostDoc> create(@RequestBody @Valid PostDocRequest postDocRequest) {
        PostDoc createdPostDoc = postDocService.write(postDocRequest.title(), postDocRequest.content());
        return new RsData<>(
                "201",
                "게시글 생성이 완료되었습니다.",
                createdPostDoc
        );
    }
}