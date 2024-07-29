1.  list all of the new annotations you learned to your annotations.md
2.  Document the microservice architeture and components/tools/dependencies
    - split one large application into multiple small and independent service based applications.
    - component
      - Spring Cloud
      - API Gateway
        - spring-cloud-starter-gateway
      - Eureka
        - Service Discovery
        - spring-cloud-starter-netflix-eureka-client
      - Load balancer
      - circuit breaker
      - Config server
      - Kafka
      - Docker
3.  What are Resilience patterns? What is circuit breaker?
    - strategies to make sure the systems can withstand and recover from failures, maintain functionality and provide reliable service.
    - Retry Pattern
    - Timeout pattern
    - Failover Pattern
    - circuit breaker:
      - Prevent an application from performing an operation that is likely to fail. it opens the circuit after a failure threshold is reached. and close it after a certain amount of time or when the service recovers.
4.  Read this article, then list the important questions, then write your answers
   1. https://www.interviewbit.com/microservices-interview-questions/#main-features-of-microservices
   2. Spring Cloud usage
      - the Spring cloud is a system that integrates with external systems. This is a short-lived framework designed to build applications quickly. It contributes significantly to microservice architecture due to its association with finite amounts of data processing. Some of the features of spring cloud are shown below:
      - eg. Distributed messaging, Circuit Breakers, Service Registration, service discovery, load balancing, cluster state, routing
5.  how to do load balance in microservice? Write a long Summary by yourself.
   1.  https://www.geeksforgeeks.org/load-balancer-system-design-interview-question/
   2. https://www.fullstack.cafe/blog/load-balancing-interview-questions
    - distributes and balances the incoming traffice among the servers to provide high availability. LB can put in many places, between clients and servers, between servers and servers.
    - algorithms like: Round Robin, weighted Round Robin, least connection method, least response time method.
6.  How to do service discovery?
    - Service discovery is a key component in microservices architecture, allowing services to find and communicate with each other without hardcoding network locations.
    - Eureka
      - is a REST-based service registry for resilient mid-tier load balancing and failover.
      - Set up  Eureka Server
      - set up Eureka Client
        - add dependencies
        - enable Eureka Server
        - Configure Eureka Server
      
        
7.  prepare your own answers for each questions  https://www.interviewbit.com/kafka-interview-questions/#
    purpose-of-partitions-in-kafka
    1. Kafka Interview Questions for Freshers
    2. Kafka Interview Questions for Experienced
    3.MCQ on Kafka