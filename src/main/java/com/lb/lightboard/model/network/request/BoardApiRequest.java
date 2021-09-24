package com.lb.lightboard.model.network.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardApiRequest {

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

}
