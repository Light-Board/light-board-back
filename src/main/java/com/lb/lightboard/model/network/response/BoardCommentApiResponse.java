package com.lb.lightboard.model.network.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lb.lightboard.model.entity.Board;
import com.lb.lightboard.model.entity.BoardComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardCommentApiResponse {

    private Long boardCommentId;

    private Long boardId;

    private String comment;

    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    private LocalDateTime createdAt;

    private Long createdUserNo;

    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    private LocalDateTime updatedAt;

    private Long updatedUserNo;

    public BoardCommentApiResponse(BoardComment boardComment) {
        this.boardCommentId = boardComment.getBoardCommentId();
        this.boardId = boardComment.getBoardId();
        this.comment = boardComment.getComment();
        this.createdAt = boardComment.getCreatedAt();
        this.createdUserNo = boardComment.getCreatedUserNo();
        this.updatedAt = boardComment.getUpdatedAt();
        this.updatedUserNo = boardComment.getUpdatedUserNo();
    }

}
