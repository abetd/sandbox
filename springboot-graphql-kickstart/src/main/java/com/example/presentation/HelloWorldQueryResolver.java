package com.example.presentation;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldQueryResolver implements GraphQLQueryResolver {

    public String hello() {
        return "Hello World.";
    }
}
