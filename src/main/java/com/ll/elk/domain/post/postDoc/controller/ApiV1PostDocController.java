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

    @PostMapping("/write")
    public RsData<PostDoc> write(
            @RequestBody @Valid PostDocWriteRequest writeRequest
    ) {

        PostDoc postDoc =  postDocService.write(writeRequest.title, writeRequest.content);
        return new RsData(
                "201",
                "게시글이 생성 되었습니다.",
                postDoc
        );
    }

    record PostDocWriteRequest(
            @NotBlank String title,
            @NotBlank String content
    ) {}

    @GetMapping("/search")
    public List<PostDoc> search(@RequestParam("keyword") String keyword) {
        return postDocService.findByTitle(keyword);
    }

}
