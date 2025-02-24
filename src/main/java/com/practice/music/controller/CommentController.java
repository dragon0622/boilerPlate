package com.practice.music.controller;

import com.practice.music.dto.CommentRequestDTO;
import com.practice.music.dto.CommentResponseDTO;
import com.practice.music.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    public ResponseEntity<CommentResponseDTO> addComment(@RequestBody CommentRequestDTO commentRequestDTO){
        CommentResponseDTO commentResponse = commentService.addComment(commentRequestDTO);
        return ResponseEntity.ok(commentResponse);
    }

    public ResponseEntity<CommentResponseDTO> deleteComment(@RequestBody CommentRequestDTO commentRequestDTO){
        CommentResponseDTO commentResponse = commentService.deleteComment(commentRequestDTO);
        return ResponseEntity.ok(commentResponse);
    }
}
