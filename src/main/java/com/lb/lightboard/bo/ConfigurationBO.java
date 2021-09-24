package com.lb.lightboard.bo;

import com.lb.lightboard.model.entity.Configuration;
import com.lb.lightboard.model.network.Header;
import com.lb.lightboard.model.network.request.ConfigurationApiRequest;
import com.lb.lightboard.model.network.response.ConfigurationApiResponse;
import com.lb.lightboard.model.network.status.ApiResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ConfigurationBO extends BaseBO<ConfigurationApiRequest, ConfigurationApiResponse, Configuration> {
	@Override
	public Header<ConfigurationApiResponse> create(Header<ConfigurationApiRequest> request) {
		return null;
	}
	
	@Override
	public Header<ConfigurationApiResponse> read(long id) {
		Configuration configuration = baseRepository.findById(id).orElse(null);
		if (configuration == null) {
			return Header.ERROR("There is no any data for id");
		}
		
		log.info("[Read Configuration] Configuration : {}", configuration);
		return new Header<>(new ConfigurationApiResponse(configuration), ApiResponseStatus.READ_DATA, "Configuration");
	}
	
	@Override
	public Header<List<ConfigurationApiResponse>> search(Pageable pageable) {
		return null;
	}
	
	@Override
	public Header<ConfigurationApiResponse> update(Header<ConfigurationApiRequest> request) {
		ConfigurationApiRequest configurationApiRequest = request.getData();
		
		Configuration configuration = baseRepository.findById(configurationApiRequest.getConfigurationId()).orElse(null);
		if (configuration == null) {
			return Header.ERROR("There is no any data for id");
		}
		
		Configuration newConfiguration = new Configuration(configurationApiRequest);
		baseRepository.save(newConfiguration);
		log.info("[Update Configuration] Configuration : {}", newConfiguration);
		return new Header<>(new ConfigurationApiResponse(newConfiguration), ApiResponseStatus.UPDATE_DATA, "Configuration");
	}
	
	@Override
	public Header<ConfigurationApiResponse> delete(long id) {
		return null;
	}
}
