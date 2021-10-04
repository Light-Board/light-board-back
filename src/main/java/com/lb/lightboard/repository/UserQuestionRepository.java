package com.lb.lightboard.repository;

import com.lb.lightboard.model.entity.UserQuestion;
import com.lb.lightboard.model.type.UserQuestionType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserQuestionRepository extends JpaRepository<UserQuestion, UserQuestionType> {
}
