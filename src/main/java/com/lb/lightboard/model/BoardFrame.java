package com.lb.lightboard.model;

import com.lb.lightboard.model.type.UserAuthorityType;
import com.lb.lightboard.model.type.UserStatusType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "board_frame")
public class BoardFrame {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_frame_id")
	long boardFrameId;
	@Column(name = "board_frame_name")
	String boardFrameName;
	@Column(name = "child_board_frame_id")
	String childBoardFrameId;
	@Column(name = "access_level")
	String accessLevel;
	@Column(name = "created_at")
	long createAt;
	@Column(name = "created_user_no")
	long createdUserNo;
	@Column(name = "updated_at")
	long updateAt;
	@Column(name = "updated_user_no")
	long updatedUserNo;
}
