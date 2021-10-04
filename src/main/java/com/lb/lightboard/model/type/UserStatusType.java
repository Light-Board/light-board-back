package com.lb.lightboard.model.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.apache.commons.collections4.MapUtils;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum UserStatusType {
	ACTIVATE("A"),
	INACTIVATE("I");

	String dbCode;

	private static final Map<String, UserStatusType> DB_CODES =
		Collections.unmodifiableMap(Stream.of(values()).collect(
			Collectors.toMap(UserStatusType::getDbCode, Function.identity())));

	public static UserStatusType find(String dbCode) {
		return MapUtils.getObject(DB_CODES, dbCode, null);
	}
}
