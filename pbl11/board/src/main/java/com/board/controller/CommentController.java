package com.board.controller;


import com.board.domain.request.CommentDeleteRequest;
import com.board.domain.request.CommentEditRequest;
import com.board.domain.request.CommentPostRequest;
import com.board.domain.response.BoardResponse;
import com.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("comment")
    public BoardResponse post(@RequestBody CommentPostRequest commentPostRequest) {
        return commentService.postComment(commentPostRequest.getBoardNo(), commentPostRequest.getCommentBody());
    }

    @PutMapping("comment")
    public String edit(@RequestBody CommentEditRequest commentEditRequest) {
        commentService.editComment(commentEditRequest.getBoardNo(), commentEditRequest.getCommentNo(), commentEditRequest.getCommentBody());

        return "OK";
    }

    @DeleteMapping("comment")
    public String delete(@RequestBody CommentDeleteRequest commentDeleteRequest) {
        commentService.deleteComment(commentDeleteRequest.getBoardNo(), commentDeleteRequest.getCommentNo());


        return "OK";

    }

}
