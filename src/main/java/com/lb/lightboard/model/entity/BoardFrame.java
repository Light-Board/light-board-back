package com.lb.lightboard.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "board_frame")
//@ToString(exclude = {"orderGroup"}) // stackOverFlow (서로 tostring 하면서 무한 참조 방지) -> 관계 설정 해줄때 참조해야함!
@Builder // 생성자패턴!
public class BoardFrame {
	@Id
	@Column(name = "board_frame_id")
	Long boardFrameId;

	@Column(name = "board_frame_name")
	String boardFrameName;

	@Column(name = "child_board_frame_id")
	String childBoardFrameId;

	@Column(name = "access_level")
	String accessLevel;

	@Column(name = "created_at")
	LocalDateTime createdAt;

	@Column(name = "created_user_no")
	Long createdUserNo;

	@Column(name = "updated_at")
	LocalDateTime updatedAt;

	@Column(name = "updated_user_no")
	Long updatedUserNo;
}
