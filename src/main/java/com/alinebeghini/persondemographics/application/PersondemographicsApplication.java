package com.alinebeghini.persondemographics.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
  
@SpringBootApplication
@EntityScan(basePackages = { "com.alinebeghini.persondemographics.entity" })
@EnableJpaRepositories(basePackages = { "com.alinebeghini.persondemographics.repository" })
@ComponentScan(basePackages = {"com.alinebeghini.persondemographics.controller"})
public class PersondemographicsApplication {
      public static void main(String[] args) {
            SpringApplication.run(PersondemographicsApplication.class, args);
      }
}
