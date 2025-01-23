package com.board.repository;

import com.board.domain.entity.Comment;
import com.board.domain.entity.QBoard;
import com.board.domain.entity.QComment;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class CommentRepositoryCustom {

    private final JPAQueryFactory queryFactory;


    private static final QComment comment = QComment.comment;
    public Comment find(Long commentNo, Long boardNo) {
        return queryFactory.select(comment)
                .from(comment)
                .where(comment.commentNo.eq(commentNo))
                .where(QBoard.board.boardNo.eq(boardNo))
                .fetchOne();
    }
}
