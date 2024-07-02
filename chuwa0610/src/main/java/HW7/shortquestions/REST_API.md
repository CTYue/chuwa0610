## 5 GET APIs with different response type

- response：text
- URL: https://baconipsum.com/api/?type=meat-and-filler
```text
[
  "Pig frankfurter occaecat pork loin est ipsum venison.  Eu consequat filet mignon, fatback cupidatat andouille tri-tip jerky.  Chicken beef ribs consequat pariatur, aliquip fatback quis shankle do short ribs biltong culpa andouille turkey.  Ad cow prosciutto adipisicing minim ex leberkas buffalo.  Cillum nostrud laborum spare ribs, burgdoggen ipsum lorem landjaeger.",
  "Incididunt dolore buffalo et do pariatur mollit.  Ullamco aliqua quis fugiat strip steak do reprehenderit.  Beef ribs adipisicing venison jerky pork chop qui.  Buffalo turducken doner, deserunt incididunt shank commodo ham hock anim velit culpa excepteur in.  Duis in leberkas pastrami bacon chicken.  Reprehenderit quis do ipsum meatball, prosciutto deserunt picanha shoulder dolore tongue adipisicing hamburger cillum.",
  "Et sausage non, andouille beef ball tip tenderloin est corned beef sirloin cillum brisket shoulder.  Anim in reprehenderit ball tip, velit ut cupidatat.  Eiusmod burgdoggen quis cillum swine.  Burgdoggen sed elit ribeye beef, porchetta cillum in pariatur in duis adipisicing.  Ribeye exercitation in capicola pancetta chuck shoulder irure ut velit aute eiusmod.  Consequat fugiat dolore, chicken porchetta occaecat burgdoggen salami.  Buffalo aliquip pariatur, pig nisi proident duis capicola.",
  "Anim sunt aliqua voluptate, sed ipsum venison nisi tenderloin cow tongue leberkas cupidatat.  Pariatur ut venison leberkas.  Corned beef ham quis, dolor consectetur non drumstick frankfurter strip steak occaecat chuck tail tempor laborum prosciutto.  Aliquip ground round eu sirloin deserunt kielbasa.  Biltong anim short ribs swine.  Venison beef ribs picanha brisket, sausage consectetur pastrami chislic.",
  "Shoulder capicola do, tongue aliquip ham hock frankfurter buffalo hamburger.  Ullamco flank meatball, dolore leberkas rump short loin alcatra sed duis strip steak short ribs eu picanha filet mignon.  Tempor in et, boudin velit meatball veniam dolore meatloaf.  Velit chicken rump alcatra fugiat.  Tongue excepteur chicken kevin corned beef."
]
```
- response html
- URL:https://httpbin.org/html
```html
<!DOCTYPE html>
<html>
  <head>
  </head>
  <body>
      <h1>Herman Melville - Moby-Dick</h1>

      <div>
        <p>
          Availing himself of the mild, summer-cool weather that now reigned in these latitudes, and in preparation for the peculiarly active pursuits shortly to be anticipated, Perth, the begrimed, blistered old blacksmith, had not removed his portable forge to the hold again, after concluding his contributory work for Ahab's leg, but still retained it on deck, fast lashed to ringbolts by the foremast; being now almost incessantly invoked by the headsmen, and harpooneers, and bowsmen to do some little job for them; altering, or repairing, or new shaping their various weapons and boat furniture. Often he would be surrounded by an eager circle, all waiting to be served; holding boat-spades, pike-heads, harpoons, and lances, and jealously watching his every sooty movement, as he toiled. Nevertheless, this old man's was a patient hammer wielded by a patient arm. No murmur, no impatience, no petulance did come from him. Silent, slow, and solemn; bowing over still further his chronically broken back, he toiled away, as if toil were life itself, and the heavy beating of his hammer the heavy beating of his heart. And so it was.—Most miserable! A peculiar walk in this old man, a certain slight but painful appearing yawing in his gait, had at an early period of the voyage excited the curiosity of the mariners. And to the importunity of their persisted questionings he had finally given in; and so it came to pass that every one now knew the shameful story of his wretched fate. Belated, and not innocently, one bitter winter's midnight, on the road running between two country towns, the blacksmith half-stupidly felt the deadly numbness stealing over him, and sought refuge in a leaning, dilapidated barn. The issue was, the loss of the extremities of both feet. Out of this revelation, part by part, at last came out the four acts of the gladness, and the one long, and as yet uncatastrophied fifth act of the grief of his life's drama. He was an old man, who, at the age of nearly sixty, had postponedly encountered that thing in sorrow's technicals called ruin. He had been an artisan of famed excellence, and with plenty to do; owned a house and garden; embraced a youthful, daughter-like, loving wife, and three blithe, ruddy children; every Sunday went to a cheerful-looking church, planted in a grove. But one night, under cover of darkness, and further concealed in a most cunning disguisement, a desperate burglar slid into his happy home, and robbed them all of everything. And darker yet to tell, the blacksmith himself did ignorantly conduct this burglar into his family's heart. It was the Bottle Conjuror! Upon the opening of that fatal cork, forth flew the fiend, and shrivelled up his home. Now, for prudent, most wise, and economic reasons, the blacksmith's shop was in the basement of his dwelling, but with a separate entrance to it; so that always had the young and loving healthy wife listened with no unhappy nervousness, but with vigorous pleasure, to the stout ringing of her young-armed old husband's hammer; whose reverberations, muffled by passing through the floors and walls, came up to her, not unsweetly, in her nursery; and so, to stout Labor's iron lullaby, the blacksmith's infants were rocked to slumber. Oh, woe on woe! Oh, Death, why canst thou not sometimes be timely? Hadst thou taken this old blacksmith to thyself ere his full ruin came upon him, then had the young widow had a delicious grief, and her orphans a truly venerable, legendary sire to dream of in their after years; and all of them a care-killing competency.
        </p>
      </div>
  </body>
</html>
```
- response JSON
- URL: https://api.github.com/users/octocat
```json
{
    "login": "octocat",
    "id": 583231,
    "node_id": "MDQ6VXNlcjU4MzIzMQ==",
    "avatar_url": "https://avatars.githubusercontent.com/u/583231?v=4",
    "gravatar_id": "",
    "url": "https://api.github.com/users/octocat",
    "html_url": "https://github.com/octocat",
    "followers_url": "https://api.github.com/users/octocat/followers",
    "following_url": "https://api.github.com/users/octocat/following{/other_user}",
    "gists_url": "https://api.github.com/users/octocat/gists{/gist_id}",
    "starred_url": "https://api.github.com/users/octocat/starred{/owner}{/repo}",
    "subscriptions_url": "https://api.github.com/users/octocat/subscriptions",
    "organizations_url": "https://api.github.com/users/octocat/orgs",
    "repos_url": "https://api.github.com/users/octocat/repos",
    "events_url": "https://api.github.com/users/octocat/events{/privacy}",
    "received_events_url": "https://api.github.com/users/octocat/received_events",
    "type": "User",
    "site_admin": false,
    "name": "The Octocat",
    "company": "@github",
    "blog": "https://github.blog",
    "location": "San Francisco",
    "email": null,
    "hireable": null,
    "bio": null,
    "twitter_username": null,
    "public_repos": 8,
    "public_gists": 8,
    "followers": 14030,
    "following": 9,
    "created_at": "2011-01-25T18:44:36Z",
    "updated_at": "2024-06-22T11:23:40Z"
}
```

- response XML
- URL: https://www.w3schools.com/xml/note.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<note>
    <to>Tove</to>
    <from>Jani</from>
    <heading>Reminder</heading>
    <body>Don't forget me this weekend!</body>
</note>
```


## 5 Post API with json request body, please also paste the response here
### (1)Raw JSON Body
- https://jsonplaceholder.typicode.com/posts
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
    "title": "foo",
    "body": "bar",
    "userId": 1,
    "id": 101
}
```
### (2)Raw JSON Body
- https://dummyapi.io/data/api/user/create
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
## 3 PUT API with json request body, please also paste the response here
### (1) https://jsonplaceholder.typicode.com/posts/1
- request
```json
{
  "title": "Updated Title",
  "body": "Updated body content"
}
```
- Response
```json
{
"title": "Updated Title",
"body": "Updated body content",
"id": 1
}
```
### (2) https://jsonplaceholder.typicode.com/posts/2
- request
```json
{
  "title": "Updated Title",
  "body": "Updated body content"
}
```
- Response
```json
{
"title": "Updated Title",
"body": "Updated body content",
"id": 2
}
```

## 2 DELETE API
- (1) https://jsonplaceholder.typicode.com/posts/1
- response
```json
{}
```

## Each example with 404, 401,500 and any http status codes you know