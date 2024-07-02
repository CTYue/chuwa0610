## GET APIs with different response type
`GET https://jsonplaceholder.typicode.com/posts/1`
```json
{
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
}
```

`GET https://www.w3schools.com/xml/note.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<note>
    <to>Tove</to>
    <from>Jani</from>
    <heading>Reminder</heading>
    <body>Don't forget me this weekend!</body>
</note>
```

`GET https://jsonplaceholder.typicode.com/posts/1/comments`

```json
[
    {
        "postId": 1,
        "id": 1,
        "name": "id labore ex et quam laborum",
        "email": "Eliseo@gardner.biz",
        "body": "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
    },
    {
        "postId": 1,
        "id": 2,
        "name": "quo vero reiciendis velit similique earum",
        "email": "Jayne_Kuhic@sydney.com",
        "body": "est natus enim nihil est dolore omnis voluptatem numquam\net omnis occaecati quod ullam at\nvoluptatem error expedita pariatur\nnihil sint nostrum voluptatem reiciendis et"
    },
    {
        "postId": 1,
        "id": 3,
        "name": "odio adipisci rerum aut animi",
        "email": "Nikita@garfield.biz",
        "body": "quia molestiae reprehenderit quasi aspernatur\naut expedita occaecati aliquam eveniet laudantium\nomnis quibusdam delectus saepe quia accusamus maiores nam est\ncum et ducimus et vero voluptates excepturi deleniti ratione"
    },
    {
        "postId": 1,
        "id": 4,
        "name": "alias odio sit",
        "email": "Lew@alysha.tv",
        "body": "non et atque\noccaecati deserunt quas accusantium unde odit nobis qui voluptatem\nquia voluptas consequuntur itaque dolor\net qui rerum deleniti ut occaecati"
    },
    {
        "postId": 1,
        "id": 5,
        "name": "vero eaque aliquid doloribus et culpa",
        "email": "Hayden@althea.biz",
        "body": "harum non quasi et ratione\ntempore iure ex voluptates in ratione\nharum architecto fugit inventore cupiditate\nvoluptates magni quo et"
    }
]

```


## Some POST example with api
`POST https://jsonplaceholder.typicode.com/posts`
```json
{
  "title": "hiii",
  "body": "body",
  "userId": 1
}
```
### response
```json
{
    "title": "hiii",
    "body": "body",
    "userId": 1,
    "id": 101
}
```


`POST https://jsonplaceholder.typicode.com/comments`
```json
{
  "postId": 1,
  "name": "hii",
  "email": "hii@example.com",
  "body": "This is a test comment."
}
```
### response 
```json
{
  "postId": 1,
  "name": "hii",
  "email": "hii@example.com",
  "body": "This is a test comment.",
  "id": 501
}
```

## Some PUT example with api
`PUT https://jsonplaceholder.typicode.com/posts/1`
```json
{
  "id": 1,
  "title": "hiii",
  "body": "body",
  "userId": 1
}
```
### response 
```json
{
    "id": 1,
    "title": "hiii",
    "body": "body",
    "userId": 1
}
```

## Some DELETE example with api
### delete posts/1 request 
`DELETE https://jsonplaceholder.typicode.com/posts/1`
Nothing return No content found
```json
{}
```

`DELETE https://jsonplaceholder.typicode.com/posts/2`
Nothing return No content found
```json
{}
```

## Some example related to status code
Requesting for post 10000 which is not found, return code 404 on postman
`GET https://jsonplaceholder.typicode.com/posts/10000`



## 
