package com.pyco.webservice;

import com.pyco.webservice.receiver.Receiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class WebServiceApplication implements CommandLineRunner {

	@Autowired
	private Receiver receiver;

	public static void main(String[] args) {
		SpringApplication.run(WebServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		receiver.getLatch().await(10000, TimeUnit.SECONDS);
	}
}
