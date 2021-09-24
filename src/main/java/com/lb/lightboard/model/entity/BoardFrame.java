package com.lb.lightboard.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "board_frame")
//@ToString(exclude = {"orderGroup"}) // stackOverFlow (서로 tostring 하면서 무한 참조 방지) -> 관계 설정 해줄때 참조해야함!
@Builder // 생성자패턴!
@Accessors(chain = true) // Test부분 살펴봐 -> 메서드 체이닝
public class BoardFrame {
	@Id
	@Column(name = "board_frame_id")
	Long boardFrameId;

	@Column(name = "board_frame_name")
	String boardFrameName;

	@Column(name = "child_board_frame_id")
	String childBoardFrameId;

	@Column(name = "access_level", columnDefinition ="char")
	String accessLevel;

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
}
