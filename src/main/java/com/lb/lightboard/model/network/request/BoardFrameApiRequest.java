package com.lb.lightboard.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardFrameApiRequest {

    private long boardFrameId;

    private String boardFrameName;

    private String childBoardFrameId;

    private String accessLevel;

    private Long createdUserNo;

//    private LocalDateTime updatedAt;

    private Long updatedUserNo;

}
