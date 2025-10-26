package com.chandanpathak2005.gmail.com.Employee.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class mapper {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
