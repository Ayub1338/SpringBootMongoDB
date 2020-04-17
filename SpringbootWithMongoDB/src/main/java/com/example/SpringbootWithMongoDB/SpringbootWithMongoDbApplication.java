package com.example.SpringbootWithMongoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@SpringBootApplication(scanBasePackages = { "com.*" })
@EnableMongoRepositories(basePackages="com.*")

public class SpringbootWithMongoDbApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWithMongoDbApplication.class, args);
	}

}
