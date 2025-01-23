package com.board.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Where(clause = "comment_status='ACTIVE'")
@SQLDelete(sql = "UPDATE comment SET comment_status='DELETE' where comment_no=?")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    private String body;

    @Enumerated(EnumType.STRING)
    private CommentStatus commentStatus;

    @ManyToOne
    private Board board;
}
