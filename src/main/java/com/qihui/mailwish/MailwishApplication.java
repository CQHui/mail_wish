package com.qihui.mailwish;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.qihui.mailwish.dao")
public class MailwishApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailwishApplication.class, args);
	}
}
