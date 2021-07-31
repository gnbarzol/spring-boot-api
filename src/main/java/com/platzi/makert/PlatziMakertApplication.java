package com.platzi.makert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlatziMakertApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(PlatziMakertApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
