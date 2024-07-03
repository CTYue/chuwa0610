# HW7
## Postman practice  
## - Practice with below examples (You can find any Open APIs on the internet):
### 5 GET APIs with different response type
1. JSON Placeholder

```
URL: https://jsonplaceholder.typicode.com/todos/1
Response Type: JSON

Response:

200 OK
{
"userId": 1,
"id": 1,
"title": "delectus aut autem",
"completed": false
}
```
2. Random.org
```
URL: https://www.random.org/integers/?num=1&min=1&max=10&col=1&base=10&format=plain&rnd=new
Response Type: Plain Text

Response:

200 OK
7
```
3. HTTP Bin
```
URL: https://httpbin.org/html
Response Type: HTML

Response:

200 OK
<html>

<head>
</head>

<body>
    <h1>Herman Melville - Moby-Dick</h1>

    <div>
        <p>
            Availing himself of the mild, summer-cool weather that now reigned in these latitudes, and in preparation
            for the peculiarly active pursuits shortly to be anticipated, Perth, the begrimed, blistered old blacksmith,
            had not removed his portable forge to the hold again, after concluding his contributory work for Ahab's leg,
            but still retained it on deck, fast lashed to ringbolts by the foremast; being now almost incessantly
            invoked by the headsmen, and harpooneers, and bowsmen to do some little job for them; altering, or
            repairing, or new shaping their various weapons and boat furniture. Often he would be surrounded by an eager
            circle, all waiting to be served; holding boat-spades, pike-heads, harpoons, and lances, and jealously
            watching his every sooty movement, as he toiled. Nevertheless, this old man's was a patient hammer wielded
            by a patient arm. No murmur, no impatience, no petulance did come from him. Silent, slow, and solemn; bowing
            over still further his chronically broken back, he toiled away, as if toil were life itself, and the heavy
            beating of his hammer the heavy beating of his heart. And so it was.—Most miserable! A peculiar walk in this
            old man, a certain slight but painful appearing yawing in his gait, had at an early period of the voyage
            excited the curiosity of the mariners. And to the importunity of their persisted questionings he had finally
            given in; and so it came to pass that every one now knew the shameful story of his wretched fate. Belated,
            and not innocently, one bitter winter's midnight, on the road running between two country towns, the
            blacksmith half-stupidly felt the deadly numbness stealing over him, and sought refuge in a leaning,
            dilapidated barn. The issue was, the loss of the extremities of both feet. Out of this revelation, part by
            part, at last came out the four acts of the gladness, and the one long, and as yet uncatastrophied fifth act
            of the grief of his life's drama. He was an old man, who, at the age of nearly sixty, had postponedly
            encountered that thing in sorrow's technicals called ruin. He had been an artisan of famed excellence, and
            with plenty to do; owned a house and garden; embraced a youthful, daughter-like, loving wife, and three
            blithe, ruddy children; every Sunday went to a cheerful-looking church, planted in a grove. But one night,
            under cover of darkness, and further concealed in a most cunning disguisement, a desperate burglar slid into
            his happy home, and robbed them all of everything. And darker yet to tell, the blacksmith himself did
            ignorantly conduct this burglar into his family's heart. It was the Bottle Conjuror! Upon the opening of
            that fatal cork, forth flew the fiend, and shrivelled up his home. Now, for prudent, most wise, and economic
            reasons, the blacksmith's shop was in the basement of his dwelling, but with a separate entrance to it; so
            that always had the young and loving healthy wife listened with no unhappy nervousness, but with vigorous
            pleasure, to the stout ringing of her young-armed old husband's hammer; whose reverberations, muffled by
            passing through the floors and walls, came up to her, not unsweetly, in her nursery; and so, to stout
            Labor's iron lullaby, the blacksmith's infants were rocked to slumber. Oh, woe on woe! Oh, Death, why canst
            thou not sometimes be timely? Hadst thou taken this old blacksmith to thyself ere his full ruin came upon
            him, then had the young widow had a delicious grief, and her orphans a truly venerable, legendary sire to
            dream of in their after years; and all of them a care-killing competency.
        </p>
    </div>
</body>

</html>
```
4. W3Schools
```
URL: https://www.w3schools.com/xml/note.xml
Response Type: XML

Response:

200 OK
<note>
    <to>Tove</to>
    <from>Jani</from>
    <heading>Reminder</heading>
    <body>Don't forget me this weekend!</body>
</note>
```
5. people.sc.fsu.edu
```
URL: https://people.sc.fsu.edu/~jburkardt/data/csv/hw_200.csv
Response Type: CSV

Response:

200 OK
"Index", Height(Inches)", "Weight(Pounds)"
1, 65.78, 112.99
2, 71.52, 136.49
3, 69.40, 153.03
4, 68.22, 142.34
5, 67.79, 144.30
6, 68.70, 123.30
7, 69.80, 141.49
8, 70.01, 136.46
9, 67.90, 112.37
10, 66.78, 120.67
11, 66.49, 127.45
12, 67.62, 114.14
13, 68.30, 125.61
14, 67.12, 122.46
15, 68.28, 116.09
16, 71.09, 140.00
17, 66.46, 129.50
18, 68.65, 142.97
19, 71.23, 137.90
20, 67.13, 124.04
21, 67.83, 141.28
22, 68.88, 143.54
23, 63.48, 97.90
24, 68.42, 129.50
25, 67.63, 141.85
26, 67.21, 129.72
27, 70.84, 142.42
28, 67.49, 131.55
29, 66.53, 108.33
30, 65.44, 113.89
31, 69.52, 103.30
32, 65.81, 120.75
33, 67.82, 125.79
34, 70.60, 136.22
35, 71.80, 140.10
36, 69.21, 128.75
37, 66.80, 141.80
38, 67.66, 121.23
39, 67.81, 131.35
40, 64.05, 106.71
41, 68.57, 124.36
42, 65.18, 124.86
43, 69.66, 139.67
44, 67.97, 137.37
45, 65.98, 106.45
46, 68.67, 128.76
47, 66.88, 145.68
48, 67.70, 116.82
49, 69.82, 143.62
50, 69.09, 134.93
51, 69.91, 147.02
52, 67.33, 126.33
53, 70.27, 125.48
54, 69.10, 115.71
55, 65.38, 123.49
56, 70.18, 147.89
57, 70.41, 155.90
58, 66.54, 128.07
59, 66.36, 119.37
60, 67.54, 133.81
61, 66.50, 128.73
62, 69.00, 137.55
63, 68.30, 129.76
64, 67.01, 128.82
65, 70.81, 135.32
66, 68.22, 109.61
67, 69.06, 142.47
68, 67.73, 132.75
69, 67.22, 103.53
70, 67.37, 124.73
71, 65.27, 129.31
72, 70.84, 134.02
73, 69.92, 140.40
74, 64.29, 102.84
75, 68.25, 128.52
76, 66.36, 120.30
77, 68.36, 138.60
78, 65.48, 132.96
79, 69.72, 115.62
80, 67.73, 122.52
81, 68.64, 134.63
82, 66.78, 121.90
83, 70.05, 155.38
84, 66.28, 128.94
85, 69.20, 129.10
86, 69.13, 139.47
87, 67.36, 140.89
88, 70.09, 131.59
89, 70.18, 121.12
90, 68.23, 131.51
91, 68.13, 136.55
92, 70.24, 141.49
93, 71.49, 140.61
94, 69.20, 112.14
95, 70.06, 133.46
96, 70.56, 131.80
97, 66.29, 120.03
98, 63.43, 123.10
99, 66.77, 128.14
100, 68.89, 115.48
101, 64.87, 102.09
102, 67.09, 130.35
103, 68.35, 134.18
104, 65.61, 98.64
105, 67.76, 114.56
106, 68.02, 123.49
107, 67.66, 123.05
108, 66.31, 126.48
109, 69.44, 128.42
110, 63.84, 127.19
111, 67.72, 122.06
112, 70.05, 127.61
113, 70.19, 131.64
114, 65.95, 111.90
115, 70.01, 122.04
116, 68.61, 128.55
117, 68.81, 132.68
118, 69.76, 136.06
119, 65.46, 115.94
120, 68.83, 136.90
121, 65.80, 119.88
122, 67.21, 109.01
123, 69.42, 128.27
124, 68.94, 135.29
125, 67.94, 106.86
126, 65.63, 123.29
127, 66.50, 109.51
128, 67.93, 119.31
129, 68.89, 140.24
130, 70.24, 133.98
131, 68.27, 132.58
132, 71.23, 130.70
133, 69.10, 115.56
134, 64.40, 123.79
135, 71.10, 128.14
136, 68.22, 135.96
137, 65.92, 116.63
138, 67.44, 126.82
139, 73.90, 151.39
140, 69.98, 130.40
141, 69.52, 136.21
142, 65.18, 113.40
143, 68.01, 125.33
144, 68.34, 127.58
145, 65.18, 107.16
146, 68.26, 116.46
147, 68.57, 133.84
148, 64.50, 112.89
149, 68.71, 130.76
150, 68.89, 137.76
151, 69.54, 125.40
152, 67.40, 138.47
153, 66.48, 120.82
154, 66.01, 140.15
155, 72.44, 136.74
156, 64.13, 106.11
157, 70.98, 158.96
158, 67.50, 108.79
159, 72.02, 138.78
160, 65.31, 115.91
161, 67.08, 146.29
162, 64.39, 109.88
163, 69.37, 139.05
164, 68.38, 119.90
165, 65.31, 128.31
166, 67.14, 127.24
167, 68.39, 115.23
168, 66.29, 124.80
169, 67.19, 126.95
170, 65.99, 111.27
171, 69.43, 122.61
172, 67.97, 124.21
173, 67.76, 124.65
174, 65.28, 119.52
175, 73.83, 139.30
176, 66.81, 104.83
177, 66.89, 123.04
178, 65.74, 118.89
179, 65.98, 121.49
180, 66.58, 119.25
181, 67.11, 135.02
182, 65.87, 116.23
183, 66.78, 109.17
184, 68.74, 124.22
185, 66.23, 141.16
186, 65.96, 129.15
187, 68.58, 127.87
188, 66.59, 120.92
189, 66.97, 127.65
190, 68.08, 101.47
191, 70.19, 144.99
192, 65.52, 110.95
193, 67.46, 132.86
194, 67.41, 146.34
195, 69.66, 145.59
196, 65.80, 120.84
197, 66.11, 115.78
198, 68.24, 128.30
199, 68.02, 127.47
200, 71.39, 127.88 
```
### 5 Post API with json request body, please also paste the response here
1. HTTPBin
```
URL: https://httpbin.org/post
Request Body:
{
  "name": "John",
  "age": 30
}
Response:
{
    "args": {},
    "data": "{\r\n  \"name\": \"John\",\r\n  \"age\": 30\r\n}\r\n",
    "files": {},
    "form": {},
    "headers": {
        "Accept": "*/*",
        "Accept-Encoding": "gzip, deflate, br",
        "Content-Length": "38",
        "Content-Type": "application/json",
        "Host": "httpbin.org",
        "Postman-Token": "17029c0d-7c5a-4e0f-b9f8-009fd5295574",
        "User-Agent": "PostmanRuntime/7.39.0",
        "X-Amzn-Trace-Id": "Root=1-66831b74-487ef17e15780c4937e187aa"
    },
    "json": {
        "age": 30,
        "name": "John"
    },
    "origin": "69.181.127.109",
    "url": "https://httpbin.org/post"
}
```
2. Postman Echo
```
URL: https://postman-echo.com/pos
Request Body:
{
  "name": "John",
  "age": 30
}
Response:
{
    "args": {},
    "data": {
        "name": "John",
        "age": 30
    },
    "files": {},
    "form": {},
    "headers": {
        "host": "postman-echo.com",
        "x-request-start": "t=1719869135.968",
        "content-length": "38",
        "x-forwarded-proto": "https",
        "x-forwarded-port": "443",
        "x-amzn-trace-id": "Root=1-66831ecf-52f0680a1227ef2b29f60bc7",
        "content-type": "application/json",
        "user-agent": "PostmanRuntime/7.39.0",
        "accept": "*/*",
        "postman-token": "03c2a7c5-dd6c-4b2c-a91d-0feb40799124",
        "accept-encoding": "gzip, deflate, br"
    },
    "json": {
        "name": "John",
        "age": 30
    },
    "url": "https://postman-echo.com/post"
}
```
3. JSONTest
```
URL: http://echo.jsontest.com/key/value/one/two
Request Body:
{
    "one": "two",
    "key": "value"
}
Response:
{
    "one": "two",
    "key": "value"
}

```
4. Dummy JSON
```
URL: https://dummyjson.com/posts/add
Request Body:
{
  "title": "Test",
  "body": "This is a test.",
  "userId": 114
}


Response:
{
    "id": 252,
    "title": "Test",
    "body": "This is a test.",
    "userId": 114
}
```
5. ReqRes
```
URL: https://reqres.in/api/users
Request Body:
{
  "name": "alice",
  "job": "foo"
}

Response:
{
    "name": "alice",
    "job": "foo",
    "id": "633",
    "createdAt": "2024-07-01T21:29:37.419Z"
}
```
### 3 PUT API with json request body, please also paste the response here
1. JSONPlaceholde
```
URL: https://jsonplaceholder.typicode.com/posts/1
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
```
2. ReqBin
```
URL: https://reqbin.com/echo/put/json
Request Body:
{
  "id": 1,
  "title": "foo",
  "body": "bar",
  "userId": 1
}
Response:
{
    "success": "true"
}
```
3. Postman Echo
```
URL: https://postman-echo.com/put
Request Body:
{
  "id": 1,
  "title": "foo",
  "body": "bar",
  "userId": 1
}
Response:
{
    "success": "true"
}
```
### 2 DELETE API
1. ReqBin
```
URL: https://reqbin.com/echo/delete/json
Request Body:
{
  "id": 1,
  "title": "foo",
  "body": "bar",
  "userId": 1
}
Response:
{
    "success": "true"
}
```
2. Postman Echo
```
URL: https://postman-echo.com/delete
Request Body:
{
  "id": 1,
  "title": "foo",
  "body": "bar",
  "userId": 1
}
Response:
{
    "success": "true"
}
```
### Each example with 404, 401,500 and any http status codes you know
1. GET https://apod.nasa.gov/apod/image/1901/NGC6357_Hubble_960.jpg
Response : 404 Not Found
```
<html>

<head>
    <title>404 Not Found</title>
</head>

<body>
    <h1>Not Found</h1>
    <p>The requested URL /apod/image/1901/NGC6357_Hubble_960.jpg was not found on this server.</p>
</body>

</html>
```
2. Server Error\
   Resoponse: 500 Internal Server Error

3. GET http://api.openweathermap.org/data/2.5/weather
Response: 401 Unauthorized
```
{
    "cod": 401,
    "message": "Invalid API key. Please see https://openweathermap.org/faq#error401 for more info."
}
```

## 1.  create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.
- File name: [annotations.md](annotations.md)
- you'd better also list a code example under the annotations.
## 2.  explain how the below annotaitons specify the table in database?
```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;

@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```
- The @Column annotation is used to specify details about the columns in the database table that correspond to the annotated fields in the Java class.
- In the first half, "name" will be mapped to columnDefinitions defines the boundaries of a column "name"". It is set that the type should be varchar(255) and have a default value of 'John Snow'.
- In the second half, "studentName" wille be mapped to a column named "STUDENT_NAME" with restriction of length<=50 and cannot be NULL, and can be non-unique.
## 3.  What is the default column names of the table in database for  @Column ?
```java
   @Column
   private String firstName;
   @Column
   private String operatingSystem;
```
If no names are given, it will use the same name teh variable as the default column name.\
Here the columns will be "firstName" and "operatingSystem" 
## 4.  What are the layers in springboot application? what is the role of each layer?
### Presentation Layer
- Handle interaction with client
- Handles HTTP request and response
### Business Layer
- Contains business logic of the applications
- process data from previous layer
### Persistence Layer
- Manages storage, and interaction with database
- Contains Data access logics like access, retrieve and update data in database
### Database Layer
- Where the actual data is stored
- Executes queries and transactions
## 5.  Describe the flow in all of the layers if an API is called by Postman.
### Presentation Layer
- Takes in the client request eg.`` "POST /api/users"`` with JSON body
- Make sure inputs are valid before send to next layer
- Present data from business layer as HTTP 201 response with response body
### Business Layer
- Process the incoming data, apply any business rules
- Calls Persistence layer for data access.
### Persistence Layer
- Interacts with Database to execute queries like SQL queries.
### Database Layer
- Execute the queries, return any result if necessary.
## 6.  What is the application.properties? do you know application.yml?
It is a file used to configure the application, such as Server port, link to DB, access username and passwords,etc.\
application.yml is an alternative of application.properties. It is more readable with hierarchical structures
## 7.  Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to
    MongoDB;
-  1.  https://www.mongodb.com/compatibility/spring-boot

