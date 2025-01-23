package com.board.domain.request;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentPostRequest {
    private Long boardNo;
    private String commentBody;
}
