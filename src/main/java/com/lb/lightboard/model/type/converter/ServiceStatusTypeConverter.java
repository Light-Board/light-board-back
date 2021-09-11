package com.lb.lightboard.model.type.converter;

import com.lb.lightboard.model.type.ServiceStatusType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ServiceStatusTypeConverter implements AttributeConverter<ServiceStatusType, String> {
	
	@Override
	public String convertToDatabaseColumn(ServiceStatusType attribute) {
		return attribute.getDbCode();
	}
	
	@Override
	public ServiceStatusType convertToEntityAttribute(String dbData) {
		return ServiceStatusType.find(dbData);
	}
}
