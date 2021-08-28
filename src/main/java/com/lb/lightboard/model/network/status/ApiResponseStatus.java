package com.lb.lightboard.model.network.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ApiResponseStatus {
	// SUCCESS
	CREATE_DATA("200", "[Create] %s data"),
	READ_DATA("200", "[Read] %s data"),
	
	// ERROR
	CREATE_FAIL("400", "[Create Fail] %s data");
	
	String result;
	String description;
}
