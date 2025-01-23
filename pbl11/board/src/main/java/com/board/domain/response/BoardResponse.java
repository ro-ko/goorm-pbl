package com.board.domain.response;


import com.board.domain.entity.Board;
import com.board.domain.entity.BoardStatus;
import com.board.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
public class BoardResponse {

    private Long boardNo;
    private String title;
    private String body;
    private BoardStatus boardStatus;
    private List<CommentResponse> comments;

    static public BoardResponse from(Board board) {
        return new BoardResponse(
                board.getBoardNo(),
                board.getTitle(),
                board.getBody(),
                board.getBoardStatus(),
                board.getComments().stream().map(CommentResponse::from).collect(Collectors.toList())
        );
    }

}
