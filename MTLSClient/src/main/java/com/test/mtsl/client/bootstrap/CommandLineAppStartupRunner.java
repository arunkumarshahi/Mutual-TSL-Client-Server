package com.test.mtsl.client.bootstrap;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.test.mtsl.client.config.AppConfig;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);
	@Autowired
	Environment env;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	AppConfig appConfig;

	@Override
	public void run(String... args) throws Exception {
		String serviceEndpoint = env.getProperty("endpoint.mtls-service");
		Map<String, String> vars = new HashMap<>();
		vars.put("name", "Arun K");
        logger.info("{} read from properties ...",appConfig.getTitle());
		// String
		// greetingMsg=restTemplate.getForObject("http://localhost:8080/api/name/{name}",
		String greetingMsg = restTemplate.getForObject("https://localhost:9002/api/name/{name}", String.class, vars);

		logger.info(
				"Application started with command-line arguments: {} . \n To kill this application, press Ctrl + C.",
				greetingMsg);
	}
}