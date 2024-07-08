package com.example.xhs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class XhsApplication {

	public static void main(String[] args) {
		SpringApplication.run(XhsApplication.class, args);
		List<Integer> arr = Arrays.asList(1,2,3);
		System.out.println(arr);
	}

}
