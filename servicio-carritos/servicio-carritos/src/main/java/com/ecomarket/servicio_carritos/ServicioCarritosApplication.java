package com.ecomarket.servicio_carritos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServicioCarritosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioCarritosApplication.class, args);
	}

}
