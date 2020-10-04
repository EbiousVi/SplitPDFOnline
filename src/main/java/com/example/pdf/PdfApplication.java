package com.example.pdf;

import com.example.pdf.Service.StorageProperties;
import com.example.pdf.Service.StorageServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class PdfApplication {
	public static void main(String[] args) {
		SpringApplication.run(PdfApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageServiceImpl storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
