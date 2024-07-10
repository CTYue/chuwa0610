package com.chuwa.learn.streamAPI;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
public class streamAPI {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product((long)1, "Books", "name1", 10.0));
        list.add(new Product((long)2, "Baby", "name2", 100.0));
        list.add(new Product((long)3, "Books", "name3", 200.0));
        list.add(new Product((long)4, "Books", "name4", 500.0));
        list.add(new Product((long)5, "Toys", "name4", 500.0));
        // "Obtain a list of product with category = \"Books\" and price > 100"
        List<Product> result = list.stream()
                .filter(e -> e.getCategory().equalsIgnoreCase("Books"))
                .filter(e -> e.getPrice() > 100)
//                .toList();
                .collect(Collectors.toList());

        System.out.println(result);
        System.out.println("----");

        // "Obtain a list of product with category = \"Books\" and price > 100 (using Predicate chaining for filter)")

        Predicate<Product> catogoryFilter = e -> e.getCategory().equalsIgnoreCase("Books");
        Predicate<Product> priceFilter = e -> e.getPrice() > 100;

//        List<Product> res1 = list.stream().filter(catogoryFilter)
//                            .filter(priceFilter)
//                            .collect(Collectors.toList());
        List<Product> res1 =list.stream().filter(catogoryFilter.and(priceFilter))//.test(p))
                .toList();
        list.stream().filter(p -> catogoryFilter.and(priceFilter).test(p))
                .toList();
        res1.stream().forEach(System.out::println);
        System.out.println("----res1 end");

        // @DisplayName("Obtain a list of product with category = \"Books\" and price > 100 (using BiPredicate for filter)")
        BiPredicate<Product, String> catogorityFilter = (p , c) -> p.getCategory().equalsIgnoreCase(c);
        List<Product> res2 =  list.stream().filter(product -> catogorityFilter.test(product, "Books") && product.getPrice() > 100)
                .toList();
        res2.stream().forEach(System.out::println);
        System.out.println("----res2 end");

        // @DisplayName("Obtain a list of order with product category = \"Baby\"")
            // order.stream().filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby"))).toList()
        // @DisplayName("Obtain a list of product with category = “Toys” and then apply 10% discount\"")

        // peek 会修改list
//        List<Product> res3 = list.stream()
//                .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
//                .peek(p->p.setPrice(p.getPrice()*0.9))
//                .toList();
        List<Product> res3  = list.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
                .map(p -> new Product(p.getId(), p.getCategory(), p.getName(), p.getPrice() * 0.9))
                .toList();
        res3.stream().forEach(System.out::println);
        System.out.println("——————res3");

        //@DisplayName("Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021")
        //  flatMap method in Java's Stream API is used to flatten nested structures, particularly when dealing with streams of collections or arrays.
        List<Order>  orders = new ArrayList<>();
        List<Product> res4 = orders.stream()
                .filter(o -> o.getCustomer().getTier() == 2)
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021,2,1)) >= 0)
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021,4,1)) <= 0)
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .toList();

        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(1,2,3,4));
        arr.add(Arrays.asList(4,5,6,7));
        arr.add(Arrays.asList(8,9,10,11));
        arr.add(Arrays.asList(12,13,14,15));

//        arr.stream().flatMap(o -> o.stream()).forEach(System.out::println);
        System.out.println("3 cheapest");
        //@DisplayName("Get the 3 cheapest products of \"Books\" category")
        list.stream().filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .sorted(Comparator.comparing(Product::getPrice))
                        .limit(3).forEach(System.out::println);




        System.out.println("Get the 3 most recent placed order");
        orders.stream().sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3).forEach(System.out::println);

        System.out.println("Get a list of products which was ordered on 15-Mar-2021");
        orders.stream().filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021,3,15)))
                .flatMap(o -> o.getProducts().stream())
                .distinct().toList();

        System.out.println("Calculate the total lump of all orders placed in Feb 2021");
        double total = orders.stream().filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021,2,1)) >= 0)
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021,3,1)) < 0)
                .flatMap(o -> o.getProducts().stream())
                .mapToDouble(Product::getPrice).sum();

        System.out.println("Calculate the total lump of all orders placed in Feb 2021 (using reduce with BiFunction)");
        BiFunction<Double, Product, Double> accumulator = (acc, product) -> acc + product.getPrice();
        double total2 = orders.stream().filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021,2,1)) >= 0)
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021,3,1)) < 0)
                .flatMap(o -> o.getProducts().stream())
                .reduce(0D, accumulator, Double::sum);
        double test = list.stream().reduce(0D, accumulator, Double::sum);
        System.out.println("price " + test);

        System.out.println("Calculate the average price of all orders placed on 15-Mar-2021");
        double avg = orders.stream()
                .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021,03,15)))
                .flatMap(o -> o.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(1.0);
        double avg1 = list.stream().mapToDouble(Product::getPrice).average().getAsDouble();
        System.out.println(avg1);
        System.out.println(avg);

        System.out.println("\"Obtain statistics summary of all products belong to \\\"Books\\\" category");
        DoubleSummaryStatistics statistics = list.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .mapToDouble(Product::getPrice)
                .summaryStatistics();
        System.out.println(statistics);

        System.out.println("Obtain a mapping of order id and the order's product count");
//        Map<Long, Integer> map = orders.stream()
//                .collect(Collectors.toMap(Order::getId, o -> o.getProducts().size())
//                        );
        Map<Long, Double> map = list.stream()
                .collect(Collectors.toMap(Product::getId, Product::getPrice)
                );
        System.out.println(map);
        System.out.println("Obtain a data map of customer and list of orders");
        Map<Customer, List<Order>> map1 = orders.stream()
                        .collect(
                          Collectors.groupingBy(Order::getCustomer)
                        );
        System.out.println("Obtain a data map of customer_id and list of order_id(s)");
        Map<Long, List<Long>> map2 = orders.stream()
                        .collect(Collectors.groupingBy(
                                o -> o.getCustomer().getId(),
                                HashMap::new, Collectors.mapping(Order::getId, Collectors.toList())
                        ));
        System.out.println("Obtain a data map with order and its total price");
        Map<Order, Double> map3 = orders.stream()
                        .collect(Collectors.toMap(
                           Function.identity(), order -> order.getProducts().stream().mapToDouble(Product::getPrice).sum()
                        ));
        System.out.println("Obtain a data map with order and its total price (using reduce)");
        Map<Long, Double> map4 = orders.stream()
                        .collect(Collectors.toMap(Order::getId, o -> o.getProducts().stream().reduce(0D, (acc, product) -> acc + product.getPrice(), Double::sum) ));
        System.out.println("Obtain a data map of product name by category");
        Map<String, List<String>> map5 = list.stream()
                        .collect(Collectors.groupingBy(Product::getCategory, Collectors.mapping(Product::getName, Collectors.toList())));
        System.out.println("Get the most expensive product per category");
        Map<String, Optional<Product>> map6 = list.stream().collect(
            Collectors.groupingBy(Product::getCategory, Collectors.maxBy(Comparator.comparing(Product::getPrice)))
        );
        System.out.println("Get the most expensive product (by name) per category");
        Map<String, String> map7 = list.stream().collect(
                Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Product::getPrice)),
                                p -> p.map(Product::getName).orElse(null)
                        )
                )

        );


        int nums = {1,2,3,2};
        Arrays.stream(nums).

    }
}
