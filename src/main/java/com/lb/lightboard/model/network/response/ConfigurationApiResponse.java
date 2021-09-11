package com.lb.lightboard.model.network.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lb.lightboard.model.entity.Configuration;
import com.lb.lightboard.model.type.ServiceStatusType;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ConfigurationApiResponse {
	Long configurationId;
	ServiceStatusType serviceStatusType;
	String serviceName;
	String fabicon;
	@JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
	LocalDateTime updatedAt;
	Long updatedUserNo;
	
	public ConfigurationApiResponse(Configuration configuration) {
		this.configurationId = configuration.getConfigurationId();
		this.serviceStatusType = configuration.getServiceStatusType();
		this.serviceName = configuration.getServiceName();
		this.fabicon = configuration.getFabicon();
		this.updatedAt = configuration.getUpdatedAt();
		this.updatedUserNo = configuration.getUpdatedUserNo();
	}
}
