package com.lb.lightboard.model.network.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lb.lightboard.model.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardApiResponse {

    private Long boardId;

    private String boardTitle;

    private String boardDescription;

    private int boardHits;

    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    private LocalDateTime createdAt;

    private Long createdUserNo;

    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    private LocalDateTime updatedAt;

    private Long updatedUserNo;

    private String tags;

    private Long boardFrameId;

    public BoardApiResponse(Board board) {
        this.boardId = board.getBoardId();
        this.boardTitle = board.getBoardTitle();
        this.boardDescription = board.getBoardDescription();
        this.boardHits = board.getBoardHits();
        this.createdAt = board.getCreatedAt();
        this.createdUserNo = board.getCreatedUserNo();
        this.updatedAt = board.getUpdatedAt();
        this.updatedUserNo = board.getUpdatedUserNo();
        this.tags = board.getTags();
        this.boardFrameId = board.getBoardFrameId();
    }

}
