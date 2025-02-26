package com.practice.music.service;

import com.practice.music.dto.PostRequestDTO;
import com.practice.music.dto.PostResponseDTO;
import com.practice.music.entity.Post;
import com.practice.music.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponseDTO addPost(PostRequestDTO postRequestDTO) {
        Post post = Post.from(postRequestDTO);

        post.setUserId(postRequestDTO.getUserId());

        Post savedPost = postRepository.save(post);

        return PostResponseDTO.from(savedPost);
    }

    public PostResponseDTO deletePost(PostRequestDTO postRequestDTO) {
        return null;
    }
}
