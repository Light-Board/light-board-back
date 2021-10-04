package com.lb.lightboard.model.type.converter;

import com.lb.lightboard.model.type.UserQuestionType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserQuestionTypeConverter implements AttributeConverter<UserQuestionType, Integer> {
	@Override
	public Integer convertToDatabaseColumn(UserQuestionType attribute) {
		return attribute.getDbCode();
	}
	
	@Override
	public UserQuestionType convertToEntityAttribute(Integer dbData) {
		return UserQuestionType.find(dbData);
	}
}
