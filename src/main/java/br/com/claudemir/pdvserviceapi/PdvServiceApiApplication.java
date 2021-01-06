package br.com.claudemir.pdvserviceapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.claudemir.pdvserviceapi.service.DBService;

@SpringBootApplication
public class PdvServiceApiApplication implements CommandLineRunner {

	@Autowired
	DBService dBService;

	public static void main(String[] args) {
		SpringApplication.run(PdvServiceApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		dBService.initDB();

	}

}
