package com.lb.lightboard.model.network.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ApiResponseStatus {
	// SUCCESS
	CREATE_DATA("201", "[Create] %s data"),
	READ_DATA("200", "[Read] %s data"),
	SEARCH_DATA("200", "[Search] %s data"),
	UPDATE_DATA("201", "[Update] %s data"),
	DELETE_DATA("201", "[DELETE] %s data"),
	
	// ERROR
	CREATE_FAIL("400", "[Create Fail] %s data");
	
	String result;
	String description;
}
