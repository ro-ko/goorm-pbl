package com.board.domain.request;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardEditRequest {
    private Long boardNo;
    private String body;
}
