package com.joaopedro.case_veiculos_jr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CaseVeiculosJrApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseVeiculosJrApplication.class, args);
	}

}