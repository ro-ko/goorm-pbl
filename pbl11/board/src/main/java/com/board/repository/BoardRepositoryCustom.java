package com.board.repository;


import com.board.domain.entity.Board;
import com.board.domain.entity.QBoard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    private final static QBoard board = QBoard.board;

    public Optional<Board> find(Long boardNo) {
        return Optional.ofNullable(
                queryFactory.select(board)
                        .from(board)
                        .leftJoin(board.comments).fetchJoin()
                        .where(board.boardNo.eq(boardNo))
                        .fetchOne()
        );
    }
}
