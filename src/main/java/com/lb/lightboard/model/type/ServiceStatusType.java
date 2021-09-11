package com.lb.lightboard.model.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.collections4.MapUtils;

@Getter
@AllArgsConstructor
public enum ServiceStatusType {
	OPEN("O"),
	CLOSE("C");
	
	String dbCode;
	
	private static final Map<String, ServiceStatusType> DB_CODES =
		Collections.unmodifiableMap(Stream.of(values()).collect(
			Collectors.toMap(ServiceStatusType::getDbCode, Function.identity())));
	
	public static ServiceStatusType find(String dbCode) {
		return MapUtils.getObject(DB_CODES, dbCode, null);
	}
}
