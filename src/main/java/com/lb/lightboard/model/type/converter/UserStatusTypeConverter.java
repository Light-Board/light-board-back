package com.lb.lightboard.model.type.converter;

import com.lb.lightboard.model.type.UserStatusType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserStatusTypeConverter implements AttributeConverter<UserStatusType, String> {
	
	@Override
	public String convertToDatabaseColumn(UserStatusType attribute) {
		return attribute.getDbCode();
	}
	
	@Override
	public UserStatusType convertToEntityAttribute(String dbData) {
		return UserStatusType.find(dbData);
	}
}
