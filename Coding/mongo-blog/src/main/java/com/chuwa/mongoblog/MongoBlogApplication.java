package com.chuwa.mongoblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

// https://juejin.cn/post/7050518723806887944

//@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class })
//        (scanBasePackages = {"com.chuwa.mongoblog"})
//@EnableJpaRepositories(basePackages = "com.chuwa.mongoblog.repository.mongoDB")
//@EnableMongoRepositories(basePackages = "com.chuwa.mongoblog.repository")
@SpringBootApplication
public class MongoBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoBlogApplication.class, args);
    }

}
