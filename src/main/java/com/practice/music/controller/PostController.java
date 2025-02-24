package com.practice.music.controller;

import com.practice.music.dto.PostRequestDTO;
import com.practice.music.dto.PostResponseDTO;
import com.practice.music.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    public ResponseEntity<PostResponseDTO> addPost(@RequestBody PostRequestDTO postRequestDTO){
        PostResponseDTO postResponse = postService.addPost(postRequestDTO);
        return ResponseEntity.ok(postResponse);
    }

    public ResponseEntity<PostResponseDTO> deletePost(@RequestBody PostRequestDTO postRequestDTO){
        PostResponseDTO postResponse = postService.deletePost(postRequestDTO);
        return ResponseEntity.ok(postResponse);
    }
}
