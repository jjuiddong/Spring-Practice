package com.example.demo;

//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(classes = {DemoApplication.class})
//@SpringApplicationConfiguration(classes = DemoApplication.class)
//@WebIntergrationTest(randomPort = true)
class DemoApplicationTests {
	
//	@LocalServerPort
//	int port;

	@Test
	void contextLoads() {
		
		//assertThat(port);
		
	}

}
