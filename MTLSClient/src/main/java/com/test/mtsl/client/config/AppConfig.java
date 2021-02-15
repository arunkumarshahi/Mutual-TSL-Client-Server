package com.test.mtsl.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConfigurationProperties("sever.ssl")
//@ConfigurationProperties("app")
public class AppConfig {
	
	private String title;
	//@Value("mtls-service")
	 private String description;
	 @Value("${server.ssl.key-store-password}")
     private String keyStorePassword;
     
	 public String getKeyStorePassword() {
		return keyStorePassword;
	}

	public void setKeyStorePassword(String keyStorePassword) {
		this.keyStorePassword = keyStorePassword;
	}

	public String getTitle() {
	  return title;
	 }

	 public void setTitle(String title) {
	  this.title = title;
	 }

	 public String getDescription() {
	  return description;
	 }

	 public void setDescription(String description) {
	  this.description = description;
	 }
}
