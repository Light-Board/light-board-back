package com.lb.lightboard.model.entity;

import com.lb.lightboard.model.type.UserQuestionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user_question")
public class UserQuestion {
	@Id
	@Column(name = "question_type")
	UserQuestionType userQuestionType;
	@Column(name = "description")
	String description;
}
