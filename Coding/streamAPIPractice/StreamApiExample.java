package com.chuwa.exercise.streamAPIPractice;


import java.util.*;
import java.util.stream.Collectors;

public class StreamApiExample {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "The Pragmatic Programmer", "Books", 45.00),
                new Product(2, "Clean Code", "Books", 50.00),
                new Product(3, "Effective Java", "Books", 40.00),
                new Product(4, "Java Performance", "Books", 70.00),
                new Product(5, "Toy Car", "Toys", 15.00),
                new Product(6, "Toy Train", "Toys", 25.00),
                new Product(7, "Apple", "Groceries", 1.20),
                new Product(8, "Milk", "Groceries", 2.50)
        );

        // 1. Filter products with category "Books" and price > 40
        List<Product> filteredBooks = products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .filter(p -> p.getPrice() > 40)
                .collect(Collectors.toList());
        System.out.println("Filtered Books: " + filteredBooks);

        // 2. Get the most expensive product in the "Books" category
        Optional<Product> mostExpensiveBook = products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .max((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        mostExpensiveBook.ifPresent(book -> System.out.println("Most Expensive Book: " + book));

        // 3. Apply 10% discount to all products in the "Toys" category
        List<Product> discountedToys = products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
                .map(p -> new Product(p.getId(), p.getName(), p.getCategory(), p.getPrice() * 0.9))
                .collect(Collectors.toList());
        System.out.println("Discounted Toys: " + discountedToys);

        // 4. Get a summary of prices for all products in the "Groceries" category
        DoubleSummaryStatistics groceriesStatistics = products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Groceries"))
                .mapToDouble(Product::getPrice)
                .summaryStatistics();
        System.out.println("Groceries Statistics: " + groceriesStatistics);

        // 5. Get a mapping of product categories to their names
        Map<String, List<String>> categoryToProductNames = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(Product::getName, Collectors.toList())));
        System.out.println("Category to Product Names: " + categoryToProductNames);
    }
}

