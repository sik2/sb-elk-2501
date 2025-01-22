package com.ll.elk.domain.post.post.controller;

import com.ll.elk.domain.post.post.entity.Post;
import com.ll.elk.domain.post.post.service.PostService;
import com.ll.elk.global.rsData.RsData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class ApiV1PostController {
    private final PostService postService;

    @PostMapping("/write")
    public RsData<Post> write(
            @RequestBody @Valid PostWriteRequest writeRequest
    ) {
        Post post = postService.write(writeRequest.title, writeRequest.content);
        return new RsData(
                "201",
                "게시글이 생성 되었습니다.",
                post
        );
    }

    record PostWriteRequest(
            @NotBlank String title,
            @NotBlank String content
    ) {}

}
