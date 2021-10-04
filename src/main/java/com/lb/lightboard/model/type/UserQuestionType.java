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
public enum UserQuestionType {
	HOBBY(1);
	
	int dbCode;
	
	private static final Map<Integer, UserQuestionType> DB_CODES =
		Collections.unmodifiableMap(Stream.of(values()).collect(
			Collectors.toMap(UserQuestionType::getDbCode, Function.identity())));
	
	public static UserQuestionType find(int dbCode) {
		return MapUtils.getObject(DB_CODES, dbCode, null);
	}
}
