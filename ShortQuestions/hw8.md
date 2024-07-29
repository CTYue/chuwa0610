7. What’s the naming differences between GraphQL vs. REST ? Why is the differences ? 

   >REST has multiple endpoints in the form of URLs to define resources. GraphQL has a single URL endpoint. 
   >
   >GraphQl performs like a middleware to filter the data from the service to reduce the bandwidth and redundant data so that one url endpoint can handle all kinds of requests.

8. Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL. 

   >Request 10 customers' information with different IDs.
   >
   >Request the newest post from 10 different customers.

9. Finish the following API 

   REST 

   DELETE post by ID (with exception cases) 

   **GraphQL** 

   Query getAllPost 