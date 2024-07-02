package com.example.mongo_blog;

import com.example.mongo_blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableMongoRepositories
public class MongoBlogApplication{

	@Autowired
	BlogRepository blogRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongoBlogApplication.class, args);
	}

}
