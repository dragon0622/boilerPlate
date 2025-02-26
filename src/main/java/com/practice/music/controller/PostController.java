package com.practice.music.controller;

import com.practice.music.dto.CustomUserDetails;
import com.practice.music.dto.PostRequestDTO;
import com.practice.music.dto.PostResponseDTO;
import com.practice.music.entity.Post;
import com.practice.music.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public ResponseEntity<PostResponseDTO> addPost(@RequestBody PostRequestDTO postRequestDTO, @AuthenticationPrincipal
            CustomUserDetails userDetails){
        postRequestDTO.setUserId(userDetails.getUserId());
        PostResponseDTO postResponseDTO = postService.addPost(postRequestDTO);
        return ResponseEntity.ok(postResponseDTO);
    }

    @DeleteMapping("/posts")
    public ResponseEntity<PostResponseDTO> deletePost(@RequestBody PostRequestDTO postRequestDTO){
        PostResponseDTO postResponse = postService.deletePost(postRequestDTO);
        return ResponseEntity.ok(postResponse);
    }
}
