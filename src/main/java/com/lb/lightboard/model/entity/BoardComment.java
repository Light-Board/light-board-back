package com.lb.lightboard.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lb.lightboard.model.network.request.BoardApiRequest;
import com.lb.lightboard.model.network.request.BoardCommentApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "board_comment")
@Builder
public class BoardComment {
	@Id
	@Column(name = "board_comment_id")
	Long boardCommentId;

	@Column(name = "board_id")
	Long boardId;

	@Column(name = "comment")
	String comment;

	@Column(name = "thumbs_cnt")
	Long thumbsCnt;

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

	public BoardComment(BoardCommentApiRequest boardCommentApiRequest) {
		this.boardCommentId = boardCommentApiRequest.getBoardCommentId();
		this.boardId = boardCommentApiRequest.getBoardId();
		this.comment = boardCommentApiRequest.getComment();
		this.createdAt = boardCommentApiRequest.getCreatedAt();
		this.createdUserNo = boardCommentApiRequest.getCreatedUserNo();
		this.updatedAt = boardCommentApiRequest.getUpdatedAt();
		this.updatedUserNo = boardCommentApiRequest.getUpdatedUserNo();
	}
}
