package com.board.domain.request;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardWriteRequest {
    private String title;
    private String body;
}
