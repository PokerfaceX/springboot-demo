package com.example.demo.jsonplaceholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

//@Configuration
public class JSONPlaceHolderConfiguration {
    @Bean("jsonplaceholder")
    public CommandLineRunner runner(@Autowired JSONPlaceHolderClient jsonPlaceHolderClient) {
        return args-> {
            int a = jsonPlaceHolderClient.getPosts().size();
            System.out.println(a);
            System.out.println(jsonPlaceHolderClient.getPostById(1));
        };
    }
}
