package com.beta.replyservice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)

public class RestServiceApplicationTest {
	
	@Autowired
	private ReplyController replyController;
	
	@LocalServerPort
	private int localPort;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	

	@Test
	public void contextLoads() {
		
		assertTrue(replyController!=null);
	}
	
	/*@Test
	public void testEndpoint() throws Exception {
		assertTrue(this.restTemplate.getForObject("https://localhost:"+localPort+"/reply/helloworld",String.class).contains("helloworld"));
	}*/

}
