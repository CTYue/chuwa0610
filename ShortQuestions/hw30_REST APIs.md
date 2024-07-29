# HW30 / HW 7

## 1. REST API Postman Practice

### 1. 5 GET APIS with different response type
#### JSON Response:
- API: https://jsonplaceholder.typicode.com/posts/1
- Request:
```http request
GET /posts/1 HTTP/1.1
Host: jsonplaceholder.typicode.com
```
- Response
```json
{
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit... "
}
```

#### XML Response:
- API: https://www.w3schools.com/xml/note.xml
- Request:
```http request
GET /xml/note.xml HTTP/1.1
Host: www.w3schools.com
```
- Response
```xml
<note>
<to>Tove</to>
<from>Jani</from>
<heading>Reminder</heading>
<body>Don't forget me this weekend!</body>
</note>
```

#### Plain Text Response:
- API: https://baconipsum.com/api/?type=meat-and-filler
- Request:
```http request
GET /api/?type=meat-and-filler HTTP/1.1
Host: baconipsum.com
```
- Response
```plaintext
Bacon ipsum dolor amet filet mignon swine rump pork chop...
```


#### HTML Response:
- API: https://www.example.com/
- Request:
```http request
GET / HTTP/1.1
Host: www.example.com
```
- Response
```html
<!doctype html>
<html>
<head>
    <title>Example Domain</title>
    ...
</head>
<body>
    ...
</body>
</html>
```


#### Image Response:
- API: https://picsum.photos/200
- Request:
```http request
GET /200 HTTP/1.1
Host: picsum.photos
```
- Response

![hw7_1.png](hw7_1.png)

### 2. 5 Post API with json request body, please also paste the response here
#### Create a Post (json)
- API: https://jsonplaceholder.typicode.com/posts
- Request:
```http request
POST /posts HTTP/1.1
Host: jsonplaceholder.typicode.com
Content-Type: application/json

{
    "title": "foo",
    "body": "bar",
    "userId": 1
}

```
- Response
```json
{
    "title": "foo",
    "body": "bar",
    "userId": 1,
    "id": "823",
    "createdAt": "2024-07-05T16:13:18.546Z"
}
```

#### Create a User
- API: https://reqres.in/api/users
- Request:
```http request
POST /api/users HTTP/1.1
Host: reqres.in
Content-Type: application/json

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
  "id": "156",
  "createdAt": "2024-07-03T10:00:00.000Z"
}

```

#### Create a Task
- API: https://fakerestapi.azurewebsites.net/api/v1/Activities
- Request:
```http request
POST /api/v1/Activities HTTP/1.1
Host: fakerestapi.azurewebsites.net
Content-Type: application/json

{
    "id": 101,
    "title": "My Activity",
    "dueDate": "2024-07-03T10:00:00.000Z",
    "completed": false
}

```
- Response
```json
{
    "id": 101,
    "title": "My Activity",
    "dueDate": "2024-07-03T10:00:00.000Z",
    "completed": false
}

```

#### Create a Product
- API: https://fakestoreapi.com/products
- Request:
```http request
POST /products HTTP/1.1
Host: fakestoreapi.com
Content-Type: application/json

{
    "title": "Test Product",
    "price": 13.5,
    "description": "lorem ipsum set",
    "image": "https://i.pravatar.cc",
    "category": "electronic"
}

```
- Response
```json
{
    "id": 21,
    "title": "Test Product",
    "price": 13.5,
    "description": "lorem ipsum set",
    "image": "https://i.pravatar.cc",
    "category": "electronic"
}
```

#### Create a Booking
- API: https://restful-booker.herokuapp.com/booking
- Request:
```http request
POST /booking HTTP/1.1
Host: restful-booker.herokuapp.com
Content-Type: application/json

{
    "firstname": "Jim",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2024-07-03",
        "checkout": "2024-07-04"
    },
    "additionalneeds": "Breakfast"
}

```
- Response
```json
{
    "bookingid": 3800,
    "booking": {
        "firstname": "Jim",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2024-07-03",
            "checkout": "2024-07-04"
        },
        "additionalneeds": "Breakfast"
    }
}
```

### 3. 3 PUT API with json request body, please also paste the response here

#### Update a Post
- API: https://jsonplaceholder.typicode.com/posts/1
- Request:
```http request
PUT /posts/1 HTTP/1.1
Host: jsonplaceholder.typicode.com
Content-Type: application/json

{
    "id": 1,
    "title": "foo",
    "body": "ba",
    "userId": 1
}

```
- Response
```json
{
  "id": 1,
  "title": "foo",
  "body": "ba",
  "userId": 1
}

```

#### Update a User
- API: https://reqres.in/api/users/2
- Request:
```http request
PUT /api/users/2 HTTP/1.1
Host: reqres.in
Content-Type: application/json

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
    "updatedAt": "2024-07-03T10:00:00.000Z"
}

```

#### Update a Product
- API: https://fakestoreapi.com/products/7
- Request:
```http request
PUT /products/7 HTTP/1.1
Host: fakestoreapi.com
Content-Type: application/json

{
    "title": "Updated Product",
    "price": 15.0,
    "description": "updated description",
    "image": "https://i.pravatar.cc",
    "category": "electronic"
}

```
- Response
```json
{
    "id": 7,
    "title": "Updated Product",
    "price": 15.0,
    "description": "updated description",
    "image": "https://i.pravatar.cc",
    "category": "electronic"
}
```

### 4. 2 DELETE API

#### Delete a Post
- API: https://jsonplaceholder.typicode.com/posts/1
- Request:
```http request
DELETE /posts/1 HTTP/1.1
Host: jsonplaceholder.typicode.com

```
- Response
```http request
HTTP/1.1 200 OK
```


#### Delete a User
- API: https://reqres.in/api/users/2
- Request:
```http request
DELETE /api/users/2 HTTP/1.1
Host: reqres.in

```
- Response
```http request
HTTP/1.1 204 No Content

```



### 5. Each example with 404, 401,500 and any http status codes you know
- 404 Not Found
- 401 Unauthorized
- 500 Internal Server Error
- 200 OK
