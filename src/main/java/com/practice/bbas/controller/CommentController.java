package com.practice.bbas.controller;

import com.practice.bbas.dto.CommentRequestDTO;
import com.practice.bbas.dto.CommentResponseDTO;
import com.practice.bbas.service.CommentService;
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
