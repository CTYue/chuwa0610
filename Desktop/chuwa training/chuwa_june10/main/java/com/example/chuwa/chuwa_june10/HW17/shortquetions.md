
## 2.  Document the microservice architeture and components/tools/dependencies
````text
microservice architeture and components: split one large application into multiple small and independent service based applications.

components:
1.API Gateway: received the request from client, routing them to the appropriate microservices.
such as Spring Cloud Gateway, NGINX, kong.
Dependencies: authentication service, logging service

2. Service Registry and Discovery: Keeps track of service instances and their locations, allowing services to discover each other.
such as Eureka, Zookeeper, Consul
Dependencies: Config Service

3.Configuration Management: Centralized management of configuration properties for all services.
such as Spring Cloud Config, Consul
Dependencies: Version control system (such as Git)

4.Microservices (business services) : handle specific business logic, each microservice focuses on a single responsibility.
Development framework: Spring Boot, Micronaut, Quarkus
Dependencies: database, message queue, external API

4.Load balancer
5.Circuit Breaker
6.message queue: kafka
7.Container Orchestration: Docker
````
## 3.  What are Resilience patterns? What is circuit breaker?
strategies to make sure the systems can withstand and recover from failures, maintain functionality and provide reliable service.
- Retry Pattern
- Timeout pattern
- Failover Pattern
- circuit breaker:
  - Prevent an application from performing an operation that is likely to fail.
  - circuit will be opened when a failure threshold is reached. 
  - circuit  will be closed after a certain amount of time or when the service recovers.
## 4.  Read this article, then list the important questions, then write your answers
（1） https://www.interviewbit.com/microservices-interview-questions/#main-features-of-microservices
Spring Cloud is a framework for integrating external systems, especially suitable for building applications quickly. 
It is mainly used to process configuration related to microservice architecture and data for communication between services.
Some of the features of spring cloud are shown below:
Distributed messaging, Circuit Breakers, Service Registration, service discovery, load balancing, cluster state, routing
## 5.  how to do load balance in microservice? Write a long Summary by yourself.
(1)https://www.geeksforgeeks.org/load-balancer-system-design-interview-question/
(2)https://www.fullstack.cafe/blog/load-balancing-interview-questions
- distributes and balances the incoming traffic among the servers to provide high availability and response speed. 
LB can put in many places, between clients and servers, between servers and servers.
- algorithms for distributing traffic  like: 
Round Robin, weighted Round Robin, least connection method, least response time method.
## 6.  How to do service discovery?
  - Service discovery is a key component in microservices architecture, allowing services to find and communicate with each other without hardcoding network locations.
  - Eureka: is a REST-based service registry, can provide load balancing and failover at the mid-tier .
    - Set up Eureka Server
    - set up Eureka Client
      - add dependencies: add in pom.xml file
      - enable Eureka Server: add @EnableEurekaClient annotation to startup class
      - Configure Eureka Server：Configure the relevant parameters of Eureka Client in the configuration file.
## 7.  prepare your own answers for each questions  https://www.interviewbit.com/kafka-interview-questions/#purpose-of-partitions-in-kafka
  （1） Kafka Interview Questions for Freshers
  （2） Kafka Interview Questions for Experienced