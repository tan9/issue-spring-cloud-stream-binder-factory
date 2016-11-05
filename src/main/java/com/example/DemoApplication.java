package com.example;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.binder.kafka.config.KafkaBinderConfigurationProperties;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableBinding(Source.class)
@EnableConfigurationProperties(KafkaBinderConfigurationProperties.class)
public class DemoApplication {

	@Autowired
	private KafkaBinderConfigurationProperties properties;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void run() {
		System.out.println(properties.getZkConnectionString());
	}

	@Configuration
	@PropertySource("classpath:kafka-default.properties")
	public static class PropertySourceConfiguration {
	}
}
