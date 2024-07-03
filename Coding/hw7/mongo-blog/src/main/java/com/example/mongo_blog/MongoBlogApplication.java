package com.example.mongo_blog;

import com.example.mongo_blog.entity.Post;
import com.example.mongo_blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MongoBlogApplication {
	@Autowired
	PostRepository postRepository;

	public MongoBlogApplication(PostRepository postRepository) {this.postRepository = postRepository;}

	public static void main(String[] args) {

		SpringApplication.run(MongoBlogApplication.class, args);
	}

	public void run(String... args) {

		System.out.println("-----CREATE GROCERY ITEMS-----\n");

		createPosts();

		System.out.println("\n-----SHOW ALL GROCERY ITEMS-----\n");

		showAllPosts();

		System.out.println("\n-----GET ITEM BY NAME-----\n");

		getPostById(0);

/*
		System.out.println("\n-----GET ITEMS BY CATEGORY-----\n");

		getItemsByCategory("millets");

		System.out.println("\n-----UPDATE CATEGORY NAME OF SNACKS CATEGORY-----\n");

		updateCategoryName("snacks");

		System.out.println("\n-----DELETE A GROCERY ITEM-----\n");

		deleteGroceryItem("Kodo Millet");

		System.out.println("\n-----FINAL COUNT OF GROCERY ITEMS-----\n");

		findCountOfGroceryItems();
*/

		System.out.println("\n-----THANK YOU-----");

	}
	//CREATE
	void createPosts() {
		System.out.println("Data creation started...");
		postRepository.save(new Post(0L, "TestPost0","tes test","This is post0"));
		postRepository.save(new Post(1L, "TestPost1","aosjdho","This is post1"));
		postRepository.save(new Post(2L, "TestPost2","tes asdjbaksbjd","This is post2"));
		postRepository.save(new Post(3L, "TestPost3","aajajsjsjjsjs","This is post3"));
		System.out.println("Data creation complete...");
	}

	// READ
	// 1. Show all the data
	public void showAllPosts() {

		postRepository.findAll().forEach(post -> System.out.println(getWholePost(post)));
	}

	// 2. Get item by name
	public void getPostById(long id) {
		System.out.println("Getting item by name: " + id);
		Post item = postRepository.findById(id);
		System.out.println(getWholePost(item));
	}

/*	// 3. Get name and quantity of a all items of a particular category
	public void getItemsByCategory(String category) {
		System.out.println("Getting post for the category " + category);
		List<Post> list = groceryItemRepo.findAll(category);

		list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity()));
	}*/

	// 4. Get count of documents in the collection
	public void findPostCounts() {
		long count = postRepository.count();
		System.out.println("Number of posts in the collection: " + count);
	}

	// Print details in readable form

	public String getWholePost(Post post) {

		System.out.println(
				"Title: " + post.getTitle() +
						", \nDescription: " + post.getDescription() +
						", \nContent: " + post.getContent()
		);

		return "";
	}
}
