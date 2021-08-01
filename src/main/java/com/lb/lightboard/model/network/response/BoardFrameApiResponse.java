package com.lb.lightboard.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardFrameApiResponse {

    private Long boardFrameId;

    private String boardFrameName;

    private String childBoardFrameId;

    private String accessLevel;

    private LocalDateTime createdAt;

    private Long createdUserNo;

    private LocalDateTime updatedAt;

    private Long updatedUserNo;

}
