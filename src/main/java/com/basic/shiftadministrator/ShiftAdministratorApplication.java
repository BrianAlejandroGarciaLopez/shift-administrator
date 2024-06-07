package com.basic.shiftadministrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ShiftAdministratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShiftAdministratorApplication.class, args);
	}

}
