package com.lb.lightboard.model.type.converter;

import com.lb.lightboard.model.type.UserAuthorityType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserAuthorityTypeConverter implements AttributeConverter<UserAuthorityType, String> {
	@Override
	public String convertToDatabaseColumn(UserAuthorityType attribute) {
		return attribute.getDbCode();
	}
	
	@Override
	public UserAuthorityType convertToEntityAttribute(String dbData) {
		return UserAuthorityType.find(dbData);
	}
}
