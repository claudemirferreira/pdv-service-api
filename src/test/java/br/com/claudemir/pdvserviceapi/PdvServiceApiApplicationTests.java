package br.com.claudemir.pdvserviceapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.claudemir.pdvserviceapi.service.DBService;

@SpringBootTest
class PdvServiceApiApplicationTests {

	@Autowired
	DBService dBService;

	@Test
	void contextLoads() {
		dBService.initDB();
	}

}
