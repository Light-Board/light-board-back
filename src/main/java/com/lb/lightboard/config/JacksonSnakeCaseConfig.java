package com.lb.lightboard.config;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonSnakeCaseConfig {

    // data request 받을 때, return 해줄 때 snake_case 전략 사용해주기
    // PropertyNamingStrategy 대신 PropertyNamingStrategies 사용
    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();
        b.propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        return b;
    }

}
