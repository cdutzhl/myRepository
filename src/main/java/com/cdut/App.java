package com.cdut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class App {
    @RequestMapping("/home")
    String home(){
        return "Hello World!";
    }

    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }
}
