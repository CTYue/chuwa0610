# HW8

## 7. What’s the naming differences between GraphQL vs. REST ? Why is the differences ?
- REST is Resource-centric design and GraphQL is flexible and efficient data fetching.

- REST:
    - Resource-Based: Endpoints named after resources.
    - Example: /users, /users/{id}
    - HTTP Methods: GET, POST, PUT, DELETE

- GraphQL:
    - Operation-Based: Single endpoint for all operations.
    - Example: /graphql
    - Queries/Mutations: Specify operations in request body.

## 8. Provide 2 real-world examples of N+1 problem in REST that can be solved by GraphQL.

### 1.  Fetching User and Their Posts:
- REST N+1 Problem:
    - GET /users to fetch all users.
    - For each user, GET /users/{id}/posts to fetch their posts.
- GraphQL Solution:
     - Single query to fetch users and their posts
    ```java
    query {
        users {
            id
            name
            posts {
                id
                title
            }
        }
    }
    ```
### 2. Fetching Products and Their Reviews:
- REST N+1 Problem:
    - GET /products to fetch all products.
    - For each product, GET /products/{id}/reviews to fetch their reviews.
- GraphQL Solution:
    - Single query to fetch products and their reviews
    ```java
    query {
        products {
            id
            name
            reviews {
                id
                comment
            }
        }
    }
    ```
## 9. Finish the following API REST: DELETE post by ID (with exception cases) GraphQL: Query getAllPost

- REST: Endpoint: DELETE /posts/{id}
    - Controller: 
        ```java
        @DeleteMapping("/posts/{id}")
        public ResponseEntity<String> deletePostById(@PathVariable Long id) {
            // Implementation handles exceptions such as PostNotFoundException
        }
        ```
    - Service: 
        ```java
        public void deletePostById(Long id) throws PostNotFoundException {
        // Check if post exists, throw PostNotFoundException if not
        // Delete post
        }
        ```
- GraphQL: Query getAllPosts
    - Schema: 
    ```java
    type Post {
        id: ID
        title: String
        content: String
    }
    type Query {
        getAllPosts: [Post]
    }
    ```
    - Resolver:
    ```java
    @Component
    public class QueryResolver implements GraphQLQueryResolver {
        public List<Post> getAllPosts() {
            // Implementation fetches all posts
        }
    }   
    ```
    - Ex: 
    ```java
    query {
        getAllPosts {
            id
            title
            content
        }
    }
    ```