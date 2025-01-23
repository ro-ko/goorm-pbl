package com.board.service;

import com.board.domain.entity.Comment;
import com.board.domain.response.BoardResponse;
import com.board.repository.BoardRepository;
import com.board.repository.BoardRepositoryCustom;
import com.board.repository.CommentRepository;
import com.board.repository.CommentRepositoryCustom;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final BoardRepository boardRepository;
    private final BoardRepositoryCustom boardRepositoryCustom;
    private final CommentRepositoryCustom commentRepositoryCustom;
    private final CommentRepository commentRepository;

    public BoardResponse postComment(Long boardNo, String commentBody) {
        return boardRepositoryCustom.find(boardNo)
                .map(board -> board.addComment(commentBody))
                .map(boardRepository::save)
                .map(BoardResponse::from)
                .orElseThrow(() -> new RuntimeException("게시글이 존재하지 않습니다."));
    }

    public void editComment(Long boardNo, Long commentNo, String commentBody) {
        Comment comment = commentRepositoryCustom.find(commentNo, boardNo);
        if (comment == null) {
            throw new RuntimeException("댓글이 존재하지 않습니다.");
        }
        comment.setBody(commentBody);
    }

    public void deleteComment(Long boardNo, Long commentNo) {
        Comment comment = commentRepositoryCustom.find(commentNo, boardNo);
        if(comment == null) throw new RuntimeException("존재하지 않는 댓글입니다.");
        commentRepository.delete(comment);
    }
}
