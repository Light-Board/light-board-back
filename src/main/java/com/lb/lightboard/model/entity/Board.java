package com.lb.lightboard.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lb.lightboard.model.network.request.BoardApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "board")
@Builder
public class Board {
	@Id
	@Column(name = "board_id")
	Long boardId;

	@Column(name = "board_title")
	String boardTitle;

	@Column(name = "board_description")
	String boardDescription;

	@Column(name = "board_hits")
	int boardHits;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
	LocalDateTime createdAt;

	@Column(name = "created_user_no")
	Long createdUserNo;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
	LocalDateTime updatedAt;

	@Column(name = "updated_user_no")
	Long updatedUserNo;

	@Column(name = "tags")
	String tags;

	@Column(name = "board_frame_id")
	Long boardFrameId;

	public Board(BoardApiRequest boardApiRequest) {
		this.boardId = boardApiRequest.getBoardId();
		this.boardTitle = boardApiRequest.getBoardTitle();
		this.boardDescription = boardApiRequest.getBoardDescription();
		this.boardHits = boardApiRequest.getBoardHits();
		this.createdAt = boardApiRequest.getCreatedAt();
		this.createdUserNo = boardApiRequest.getCreatedUserNo();
		this.updatedAt = boardApiRequest.getUpdatedAt();
		this.updatedUserNo = boardApiRequest.getUpdatedUserNo();
		this.tags = boardApiRequest.getTags();
		this.boardFrameId = boardApiRequest.getBoardFrameId();
	}
}
