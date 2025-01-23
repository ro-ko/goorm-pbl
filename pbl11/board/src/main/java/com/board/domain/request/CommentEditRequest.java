package com.board.domain.request;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentEditRequest {
    private Long boardNo;
    private Long commentNo;
    private String commentBody;
}
