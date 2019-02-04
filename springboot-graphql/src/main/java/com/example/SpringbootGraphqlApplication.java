package com.example;

import com.coxautodev.graphql.tools.SchemaParserOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootGraphqlApplication.class, args);
    }

    @Bean
    public SchemaParserOptions schemaParserOptions(CustomObjectMapperConfigurer customObjectMapperConfigurer) {
        return SchemaParserOptions.newOptions()
                .objectMapperConfigurer(customObjectMapperConfigurer)
                .build();
    }
}

