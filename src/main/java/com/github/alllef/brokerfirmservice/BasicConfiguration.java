package com.github.alllef.brokerfirmservice;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicConfiguration {
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
