You can send a message using following curl:

<code>curl --location --request POST 'http://localhost:8088/publish?message=HellofromSpring&key=msg1'</code>

- KafkaConsumerConfig - Configuration for Kafka consumers.
- KafkaConsumerService - Service to handle message consumption from Kafka.
- KafkaController - Controller to handle HTTP requests to send messages.
- KafkaConsumerController - Controller to fetch consumer offset details and message consumption verification.
