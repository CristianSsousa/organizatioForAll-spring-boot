package com.br.csousa.organizationForAll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableMethodSecurity(securedEnabled = true)
public class OrganizationForAllApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationForAllApplication.class, args);
	}

}
