package sopt.longBlack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.longBlack.dto.response.PostsGetResponse;
import sopt.longBlack.dto.response.SinglePostGetResponse;
import sopt.longBlack.service.PostService;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("{postId}")
    public ResponseEntity<SinglePostGetResponse> getSinglePostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getById(postId));
    }

    @GetMapping
    public ResponseEntity<PostsGetResponse> getPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }
}
