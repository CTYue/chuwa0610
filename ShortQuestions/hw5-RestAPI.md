1. GET JSON Response:

API: https://jsonplaceholder.typicode.com/posts/1

Response:
{
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
}

2. GET XML Response:

API: https://www.w3schools.com/xml/note.xml

Response:
<?xml version="1.0" encoding="UTF-8"?>
<note>
    <to>Tove</to>
    <from>Jani</from>
    <heading>Reminder</heading>
    <body>Don't forget me this weekend!</body>
</note>

3. GET Plain Text Response:

API: https://baconipsum.com/api/?type=meat-and-filler

Response:
"Laboris chuck tri-tip non proident pork veniam culpa t-bone short loin ipsum.  Kielbasa quis pork loin chuck.  Laborum ullamco ham landjaeger ex consequat.  Dolore alcatra qui voluptate quis jowl pastrami filet mignon.  Consequat ipsum deserunt aliquip cupim ground round, aliqua strip steak qui turkey pig.  Bresaola ipsum deserunt biltong, venison ham nisi lorem.  Prosciutto ground round picanha ribeye, andouille qui irure landjaeger.",....

4. GET HTML Response:

API: https://www.example.com

Response:
<!doctype html>
<html>

<head>
    <title>Example Domain</title>

    <meta charset="utf-8" />
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <style type="text/css">
        body {
            background-color: #f0f0f2;
            margin: 0;
            padding: 0;
            font-family: -apple-system, system-ui, BlinkMacSystemFont, "Segoe UI", "Open Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;

        }

        div {
            width: 600px;
            margin: 5em auto;
            padding: 2em;
            background-color: #fdfdff;
            border-radius: 0.5em;
            box-shadow: 2px 3px 7px 2px rgba(0, 0, 0, 0.02);
        }

        a:link,
        a:visited {
            color: #38488f;
            text-decoration: none;
        }

        @media (max-width: 700px) {
            div {
                margin: 0 auto;
                width: auto;
            }
        }
    </style>
</head>

<body>
    <div>
        <h1>Example Domain</h1>
        <p>This domain is for use in illustrative examples in documents. You may use this
            domain in literature without prior coordination or asking for permission.</p>
        <p><a href="https://www.iana.org/domains/example">More information...</a></p>
    </div>
</body>

</html>

5. GET Image Response:

API: https://via.placeholder.com/150

Response:
150X150 image


5 Post API with json request body, please also paste the response here
1. POST Create a Post:

API: https://jsonplaceholder.typicode.com/posts

Request Body:
{
  "title": "foo",
  "body": "bar",
  "userId": 1
}
response:
{
    "title": "foo",
    "body": "bar",
    "userId": 1,
    "id": 101
}

2. POST Login:

API: https://reqres.in/api/login

Request Body:
{
  "email": "eve.holt@reqres.in",
  "password": "cityslicka"
}
Response:
{
  "token": "QpwL5tke4Pnpja7X4"
}

3. POST Register:

API: https://reqres.in/api/register

Request Body:
{
  "email": "eve.holt@reqres.in",
  "password": "pistol"
}
Response:
{
  "id": 4,
  "token": "QpwL5tke4Pnpja7X4"
}

4. POST Create a User:

API: https://reqres.in/api/users

Request Body:
{
  "name": "morpheus",
  "job": "leader"
}
Response:
{
  "id": "931",
  "createdAt": "2024-06-28T10:30:48.504Z"
}

5. POST Submit a Form:

API: https://postman-echo.com/post

Request Body:
{
  "key": "value"
}
Response:
{
  "args": {},
  "data": {
    "key": "value"
  },
  "files": {},
  "form": {},
  "headers": {
    "x-forwarded-proto": "https",
    "host": "postman-echo.com",
    "content-length": "15",
    "accept": "*/*",
    "accept-encoding": "gzip, deflate, br",
    "content-type": "application/json",
    "user-agent": "PostmanRuntime/7.28.0"
  },
  "json": {
    "key": "value"
  },
  "url": "https://postman-echo.com/post"
}


PUT APIs with JSON Request Body and Responses
1. PUT Update a Post:

API: https://jsonplaceholder.typicode.com/posts/1

Request Body:
{
  "id": 1,
  "title": "foo",
  "body": "bar",
  "userId": 1
}
Response:
{
  "id": 1,
  "title": "foo",
  "body": "bar",
  "userId": 1
}

2. PUT Update a User:

API: https://reqres.in/api/users/2

Request Body:
{
  "name": "morpheus",
  "job": "zion resident"
}
Response:
{
  "updatedAt": "2024-06-28T10:30:48.504Z"
}

3. PUT Update a Resource:

API: https://postman-echo.com/put

Request Body:
{
  "foo": "bar"
}
Response:
{
  "args": {},
  "data": {
    "foo": "bar"
  },
  "files": {},
  "form": {},
  "headers": {
    "x-forwarded-proto": "https",
    "host": "postman-echo.com",
    "content-length": "13",
    "accept": "*/*",
    "accept-encoding": "gzip, deflate, br",
    "content-type": "application/json",
    "user-agent": "PostmanRuntime/7.28.0"
  },
  "json": {
    "foo": "bar"
  },
  "url": "https://postman-echo.com/put"
}

DELETE APIs
DELETE a Post:
API: https://jsonplaceholder.typicode.com/posts/1

Response: 204 No Content

DELETE a User:

API: https://reqres.in/api/users/2

Response: 204 No Content


Example Responses with Various Status Codes
1. 404 Not Found:

GET API: https://jsonplaceholder.typicode.com/posts/9999

Response:
{
  "error": "Not Found"
}

2. 401 Unauthorized:

POST API: https://reqres.in/api/login
Request Body:
{
  "email": "peter@klaven"
}
Response:
{
  "error": "Missing password"
}

3. 500 Internal Server Error:

PUT API: https://jsonplaceholder.typicode.com/posts/1

Request Body:
{
  "id": 1,
  "title": "foo",
  "body": "bar",
  "userId": 1
}
Response: (Hypothetical)
{
  "error": "Internal Server Error"
}