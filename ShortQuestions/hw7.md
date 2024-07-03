## POSTMAN Exercise

#### HTTP GET

1. **Plain Text**

- **URL**: https://baconipsum.com/api/?type=meat-and-filler

- Response

  ```json
  [
    "Bacon ipsum dolor amet pancetta andouille doner, pastrami kielbasa pig leberkas chicken meatloaf swine venison pork chop biltong. Cupim pancetta frankfurter, pork belly ribeye andouille pig biltong pork loin kielbasa."
  ]
  ```

2. **HTML**

- **URL**: https://httpbin.org/html

- Response:

  ```html
  <!DOCTYPE html>
  <html>
    <head>
      <title>Sample</title>
    </head>
    <body>
      <h1>Sample Heading</h1>
    </body>
  </html>
  ```

3. **JSON**

- **URL**: https://api.github.com/users/octocat

- Response

  ```json
  {
    "login": "octocat",
    "id": 583231,
    "node_id": "MDQ6VXNlcjU4MzIzMQ==",
    "avatar_url": "https://avatars.githubusercontent.com/u/583231?v=4",
    ...
  }
  ```

4. **XML**

- **URL**: https://www.w3schools.com/xml/note.xml

- Response

  ```xml
  <note>
    <to>Tove</to>
    <from>Jani</from>
    <heading>Reminder</heading>
    <body>Don't forget me this weekend!</body>
  </note>
  ```

5. **Image (JPEG)**

- **URL**: https://placekitten.com/200/300

- **Response**:

  <img src="./assets/image-20240701182357728.png" alt="image-20240701182357728" style="zoom:33%;" />



#### HTTP POST

1. **JSONPlaceholder**

- **URL**: https://jsonplaceholder.typicode.com/posts

- Request Body

  ```json
  {
    "title": "foo",
    "body": "bar",
    "userId": 1
  }
  ```

- Response

  ```json
  {
    "id": 101
  }
  ```

2. **Reqres**

- **URL**: https://reqres.in/api/users

- Request Body

  ```json
  {
    "name": "morpheus",
    "job": "leader"
  }
  ```

- Response

  ```json
  {
    "name": "morpheus",
    "job": "leader",
    "id": "483",
    "createdAt": "2024-06-29T12:34:56.789Z"
  }
  ```

3. **DummyAPI**

- **URL**: https://dummyapi.io/data/api/user/create

- Request Body

  ```json
  {
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com"
  }
  ```

- Response

  ```json
  {
    "id": "60d0fe4f5311236168a109ca"
  }
  ```

4. **Petstore Swagger**

- **URL**: https://petstore.swagger.io/v2/pet

- Request Body

  ```json
  {
    "id": 12345,
    "category": {
      "id": 1,
      "name": "Dogs"
    },
    "name": "Doggie",
    "photoUrls": [
      "string"
    ],
    "tags": [
      {
        "id": 1,
        "name": "tag1"
      }
    ],
    "status": "available"
  }
  ```

- Response

  ```json
  {
    "id": 12345,
    "category": {
      "id": 1,
      "name": "Dogs"
    },
    "name": "Doggie",
    "photoUrls": [
      "string"
    ],
    "tags": [
      {
        "id": 1,
        "name": "tag1"
      }
    ],
    "status": "available"
  }
  ```

5. **Fake Store API**

- **URL**: https://fakestoreapi.com/products

- Request Body

  ```json
  {
    "title": "test product",
    "price": 13.5,
    "description": "lorem ipsum set",
    "image": "https://i.pravatar.cc",
    "category": "electronic"
  }
  ```

- Response

  ```json
  {
    "id": 21
  }
  ```

#### PUT APIs

1. **JSONPlaceholder**

   - **URL**: https://jsonplaceholder.typicode.com/posts/1

   - Request Body

     ```json
     {
       "id": 1,
       "title": "foo",
       "body": "bar",
       "userId": 1
     }
     ```

   - Response

     ```json
     {
       "id": 1,
       "title": "foo",
       "body": "bar",
       "userId": 1
     }
     ```

2. **Reqres**

   - **URL**: https://reqres.in/api/users/2

   - Request Body

     ```json
     {
       "name": "morpheus",
       "job": "zion resident"
     }
     ```

   - Response

     ```json
     {
       "name": "morpheus",
       "job": "zion resident",
       "updatedAt": "2024-06-29T12:34:56.789Z"
     }
     ```

3. **DummyAPI**

   - **URL**: https://dummyapi.io/data/api/user/60d0fe4f5311236168a109ca

   - Request Body

     ```json
     {
       "firstName": "Jane",
       "lastName": "Doe",
       "email": "jane.doe@example.com"
     }
     ```

   - Response

     ```json
     {
       "id": "60d0fe4f5311236168a109ca",
       "firstName": "Jane",
       "lastName": "Doe",
       "email": "jane.doe@example.com"
     }
     ```

#### DELETE APIs

1. **JSONPlaceholder**

   - **URL**: https://jsonplaceholder.typicode.com/posts/1

   - Response

     ```
     {}
     ```

2. **Reqres**

   - **URL**: https://reqres.in/api/users/2

   - Response

     ```
     {}
     ```





