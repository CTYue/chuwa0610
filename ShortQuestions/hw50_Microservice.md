## HW 50 - Microservice / HW 17

### 1. list all of the new annotations you learned to your annotations.md 

### 2. Document the microservice architeture and components/tools/dependencies 

- Microservices architecture is a software development style that **breaks large applications into smaller, independent parts called microservices.** 
- Each microservice has its **own business logic, database, and responsibility**, and **communicates** with other services through well-defined APIs.

#### Components

##### API Gateway

- **Purpose**: Acts as a single entry point for client requests, routing them to the appropriate microservice.
- Responsibilities:
  - Request routing
  - Load balancing
  - Authentication and authorization
  - Response aggregation
- Examples:
  - **Kong**: Open-source API Gateway
  - **Zuul**: Netflix’s API Gateway
  - **Nginx**: Can also be used as an API Gateway

##### Service Discovery

- **Purpose**: Keeps track of microservice instances and their locations.
- Responsibilities:
  - Register microservices
  - Discover service instances dynamically
- Examples:
  - **Eureka**: Service discovery from Netflix
  - **Consul**: Service discovery and configuration
  - **Zookeeper**: Distributed service coordination

##### Load Balancer

- **Purpose**: Distributes incoming traffic across multiple instances of microservices.
- Responsibilities:
  - Distribute requests evenly
  - Improve fault tolerance
- Examples:
  - **HAProxy**: High-availability load balancer
  - **Nginx**: Load balancing features

##### Config Server

- **Purpose**: Manages and provides configuration properties for microservices.
- Responsibilities:
  - Centralized configuration management
  - Dynamic updates of configuration
- Examples:
  - **Spring Cloud Config**: Provides centralized configuration management
  - **Consul**: Can also be used for configuration

##### Circuit Breaker

- **Purpose**: Provides resilience and fault tolerance by handling failures gracefully.
- Responsibilities:
  - Prevent cascading failures
  - Provide fallback options
- Examples:
  - **Hystrix**: Fault tolerance library by Netflix
  - **Resilience4j**: Lightweight fault tolerance library

##### Database

- **Purpose**: Stores and manages data for microservices.
- Types:
  - **Relational Databases**: MySQL, PostgreSQL
  - **NoSQL Databases**: MongoDB, Cassandra
- Responsibilities:
  - Data storage
  - Data retrieval and manipulation

##### Message Broker

- **Purpose**: Facilitates asynchronous communication between microservices.
- Responsibilities:
  - Message queuing
  - Publish/subscribe messaging
- Examples:
  - **RabbitMQ**: Message broker for messaging and queuing
  - **Apache Kafka**: Distributed streaming platform

##### Logging and Monitoring

- **Purpose**: Track and monitor the health and performance of microservices.
- Responsibilities:
  - Centralized logging
  - Performance monitoring
  - Alerting
- Examples:
  - **ELK Stack (Elasticsearch, Logstash, Kibana)**: For logging and visualization
  - **Prometheus**: Monitoring and alerting toolkit
  - **Grafana**: Visualization tool for metrics
  - **Zipkin**: Distributed tracing system

##### Security

- **Purpose**: Secures microservices and manages access control.
- Responsibilities:
  - Authentication
  - Authorization
- Examples:
  - **OAuth2**: Authorization framework
  - **JWT (JSON Web Tokens)**: Token-based authentication

##### Deployment Tools

- **Purpose**: Manage and automate the deployment of microservices.
- Responsibilities:
  - Containerization
  - Orchestration
  - Continuous Integration/Continuous Deployment (CI/CD)
- Examples:
  - **Docker**: Containerization platform
  - **Kubernetes**: Container orchestration platform
  - **Jenkins**: CI/CD tool for automating builds and deployments.
  - **GitLab CI/CD**: Integrated CI/CD pipeline



### 3. What are Resilience patterns? What is circuit breaker? 

- design strategies used to build systems that can handle and recover from failures gracefully. 
- ensure that a system remains reliable and available, even when some components experience issues. 

**Retry**

- **Purpose**: Automatically retries a failed operation a certain number of times before giving up.
- **How It Works**: When an operation fails, the system retries the operation after a delay. This pattern is useful for transient failures that might resolve themselves with time.

**Fallback**

- **Purpose**: Provides a default response or alternative method when a service fails.
- **How It Works**: When a service call fails, the system falls back to a predefined response or an alternative logic to ensure continued operation.

**Timeout**

- **Purpose**: Limits the time a service call can take, preventing the system from hanging indefinitely.
- **How It Works**: Sets a maximum duration for service calls. If the call exceeds this duration, it is terminated, and a fallback or error response is provided.

**Bulkhead**

- **Purpose**: Isolates failures to prevent them from affecting the entire system.
- **How It Works**: Divides the system into isolated components or "bulkheads" so that failure in one part does not cascade to other parts. For example, different microservices or database pools might be used for different functionalities.

**Rate Limiting**

- **Purpose**: Controls the rate of requests to a service to prevent overload.
- **How It Works**: Limits the number of requests a service can handle in a given time frame. Excess requests are either delayed or rejected to ensure the service is not overwhelmed.



####  What is circuit breaker? 

A specific resilience pattern designed to handle failures in a distributed system effectively. It prevents a system from making repeated requests to a failing service, thereby avoiding further strain and allowing the service time to recover.

#### Components

- **Closed State**: In normal operating status, **all requests are allowed** through to the service.
  - If the service responds **successfully**, the circuit breaker **continues** to operate in this state. If there are **failures**, the circuit breaker monitors the failure rate.
- **Open State**: **blocks all requests** from reaching the failed service, returning an error directly or executing fallback logic.
  -  This state is triggered when the failure rate exceeds a threshold. (from closed state)
  - The circuit breaker redirects requests to a fallback mechanism or an error response. 
  - After a timeout period, the circuit breaker transitions to a half-open state to test if the service has recovered.
- **Half-Open State**：Allows a limited number of requests to pass through to test if the service is operational again.
  - If these requests succeed, the circuit breaker transitions back to the closed state. If they fail, the circuit breaker returns to the open state.



### 4. Read this article, then list the important questions, then write your answers 

1. https://www.interviewbit.com/microservices-interview-questions/#main-features-of-microservices 



### 5. how to do load balance in microservice? Write a long Summary by yourself. 

1. https://www.geeksforgeeks.org/load-balancer-system-design-interview-question/ 

2. https://www.fullstack.cafe/blog/load-balancing-interview-questions 



### 6. How to do service discovery? 

**Deploy a Service Registry**

- Deploy Eureka, Consul, Zookeeper, or Etcd as your service registry.

**Service Registration**

- Service instances register their metadata (IP address, port, health status, etc.) with the service registry upon startup.

**Service Discovery**

- Clients or load balancers query the service registry to get the list of available service instances.

**Service Invocation**

- Clients or load balancers choose a service instance from the list and make the request.

**Health Checks**

- The service registry performs periodic health checks on registered service instances to ensure they are healthy.
- Unhealthy instances are removed from the service registry until they become healthy again and re-register.



### 7. prepare your own answers for each questions 

https://www.interviewbit.com/kafka-interview-questions/#purpose-of-partitions-in-kafka 

1. Kafka Interview Questions for Freshers 

2. Kafka Interview Questions for Experienced 
2. MCQ on Kafka