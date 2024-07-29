# Hands-on homework on Kafka

## Step 1: Use following docker-compose file to start 3 brokers on your computer, this docker-compose also includes a kafka visualization tool, once your containers started, you may visit http://localhost:8080/ to get everything about your brokers and topics… (edited) 
See [docker-compose.yml](..%2FCoding%2Fhw18%2Fdocker-compose.yml)

## Step 2: Run https://github.com/CTYue/Spring-Producer-Consumer/ on your local, only producer is included in this repo as of now. (edited) 
See [DemoApplication.java](..%2FCoding%2Fhw18%2FSpring-Producer-Consumer-main%2Fsrc%2Fmain%2Fjava%2Fcom%2Fchuwa%2Fdemo%2FDemoApplication.java)
![kaf1.png](supportingImages%2Fkaf1.png)

## Step 3: Write your consumer application with Spring Kafka dependency, set up 3 consumers in a single consumer group.
See [KafkaConsumerService.java](..%2FCoding%2Fhw18%2FSpring-Producer-Consumer-main%2Fsrc%2Fmain%2Fjava%2Fcom%2Fchuwa%2Fdemo%2Fservice%2FKafkaConsumerService.java)
- Prove message consumption with screenshots.
  - In the center is the consumers set up with 3 consumers.
  - In the left conner is the postman sending message.
  - In the right conner is the consumer printing out received messages.
  - On the right is the webUi showing the customer with 3 consumers(consumer_group)
![kf2.png](supportingImages%2Fkf2.png)
- Please figure out a good approach to generate partition keys, so your message can be redirected to different partitions. (My demo producer curl has a fixed partition key)
With the set up in [KafkaProducerService.java](..%2FCoding%2Fhw18%2FSpring-Producer-Consumer-main%2Fsrc%2Fmain%2Fjava%2Fcom%2Fchuwa%2Fdemo%2Fservice%2FKafkaProducerService.java), The partitions is based on the key value in the request
- Even the consumer is set to 5, only 3 is assigned
![kf3.png](supportingImages%2Fkf3.png)
- Increase number of consumers in a single consumer group, observe what happens, explain your observation.
  - With 3 partitions:
    - 2 Consumers: A consumer is assigned to multiple partitions.
    - 3 Consumers: Each consumer is assigned to one partition.
    - 4 Consumers: 3 consumers are assigned to the 3 partitions, and 1 consumer remains idle.

## Step 4: Create multiple consumer groups using Spring Kafka, set up different numbers of consumers within each group, observe consumer offset,
- Prove that each consumer group is consuming messages on topics as expected, take screenshots of offset records,
- Demo different message delivery guarantees in Kafka, with necessary code or configuration changes.
Image with 2 messages delivered to 2 consumer group that first has 5 consumers, second has 2 consumers. Both delivered, and printed out on the right conner.
![kf4.png](supportingImages%2Fkf4.png)