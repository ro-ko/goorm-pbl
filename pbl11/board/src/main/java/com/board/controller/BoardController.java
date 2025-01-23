package com.board.controller;


import com.board.domain.request.BoardDeleteRequest;
import com.board.domain.request.BoardEditRequest;
import com.board.domain.request.BoardWriteRequest;
import com.board.domain.response.BoardResponse;
import com.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("boardList")
    public List<BoardResponse> searchBoardList(
            @RequestParam("page") int page,
            @RequestParam("pageSize") int pageSize,
            @RequestParam("direction") Sort.Direction direction
    ) {
        return boardService.searchBoardList(page, pageSize, direction);
    }

    @GetMapping("board")
    public BoardResponse searchBoard(
            @RequestParam("boardNO") Long boardNo
    ) {
        return boardService.getBoard(boardNo);
    }

    @PostMapping("board")
    public BoardResponse writeBoard(
            @RequestBody BoardWriteRequest boardWriteRequest
    ) {
        return boardService.writeBoard(boardWriteRequest.getTitle(), boardWriteRequest.getBody());
    }

    @PutMapping("board")
    public BoardResponse editBoard(
            @RequestBody BoardEditRequest boardEditRequest
    ) {
        return boardService.editBoard(boardEditRequest.getBoardNo(), boardEditRequest.getBody());
    }


    @DeleteMapping("board")
    public Long deleteBoard(
            @RequestBody BoardDeleteRequest boardDeleteRequest
    ) {
        return boardService.deleteBoard(boardDeleteRequest.getBoardNo());
    }
}
