package com.zpcg.SpringBootCRUD;

//import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCrudApplication {

	private static final org.jboss.logging.Logger logger = LoggerFactory.logger(SpringBootCrudApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudApplication.class, args);
		System.out.println("springBootCRUDoperations");
		logger.info("this is a info message");
		logger.warn("this is a warn message");
		logger.error("this is a error message");
	}
}
