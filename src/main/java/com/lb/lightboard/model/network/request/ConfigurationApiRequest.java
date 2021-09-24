package com.lb.lightboard.model.network.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lb.lightboard.model.type.ServiceStatusType;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ConfigurationApiRequest {
	Long configurationId;
	ServiceStatusType serviceStatusType;
	String serviceName;
	String fabicon;
	@JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
	LocalDateTime updatedAt;
	Long updatedUserNo;
}
