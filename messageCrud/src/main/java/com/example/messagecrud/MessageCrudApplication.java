package com.example.messagecrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//(scanBasePackages={"com.example.messagecrud",
//"com.example.messagecrud.controller", "com.example.messagecrud.model","com.example.messagecrud.repo"})

//@ComponentScan(basePackages = {"com.example.messagecrud"})
//@EnableJpaRepositories("com.example.messagecrud.repo")


//@SpringBootApplication
//@ComponentScan({"com.example.messagecrud*"})
//@EntityScan("com.example.messagecrud*")
//@EnableJpaRepositories("com.example.messagecrud*")
public class MessageCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageCrudApplication.class, args);
	}

}
