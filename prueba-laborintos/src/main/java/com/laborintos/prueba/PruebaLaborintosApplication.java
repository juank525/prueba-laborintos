package com.laborintos.prueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.laborintos.prueba.business.CalculatorBusiness;
import com.laborintos.prueba.business.UserBusiness;

@SpringBootApplication
public class PruebaLaborintosApplication {
	
	@Autowired 
	private UserBusiness userBusiness;
	
	@Autowired
	private CalculatorBusiness calculatorBusiness;

	public static void main(String[] args) {
		SpringApplication.run(PruebaLaborintosApplication.class, args);
	}
	
	@Bean
	CommandLineRunner lookup() {
		return args -> {
			System.err.println("CREANDO USUARIOS");
			userBusiness.createUsers();
			System.err.println("USUARIOS CREADOS");
			
			System.err.println("GUARDANDO RESULTADO OPERCIONES");
			calculatorBusiness.saveResultOperationBasic();
			System.err.println("RESULTADO GUARDADO");
		};
	}
}
