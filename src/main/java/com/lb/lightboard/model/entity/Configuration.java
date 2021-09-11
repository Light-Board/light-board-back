package com.lb.lightboard.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lb.lightboard.model.type.ServiceStatusType;
import com.lb.lightboard.model.type.converter.ServiceStatusTypeConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "configuration")
@Builder
public class Configuration {
	@Id
	@Column(name = "configuration_id")
	Long configurationId;
	
	@Convert(converter = ServiceStatusTypeConverter.class)
	@Column(name = "service_status")
	ServiceStatusType serviceStatusType;
	
	@Column(name = "service_name")
	String serviceName;
	
	@Column(name = "fabicon")
	String fabicon;
	
	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
	LocalDateTime updatedAt;
	
	@Column(name = "updated_user_no")
	Long updatedUserNo;
}
