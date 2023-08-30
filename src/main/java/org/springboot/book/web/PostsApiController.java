package org.springboot.book.web;

import lombok.RequiredArgsConstructor;
import org.springboot.book.service.PostsService;
import org.springboot.book.web.dto.PostsResponseDto;
import org.springboot.book.web.dto.PostsSaveRequestDto;
import org.springboot.book.web.dto.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    private final String API_V1_URL = "/api/v1/posts";

    @PostMapping(API_V1_URL)
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping(API_V1_URL + "/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping(API_V1_URL + "/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
