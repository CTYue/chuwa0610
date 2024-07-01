# SQL
## 1. Create oms_company_address table
```
CREATE TABLE oms_company_addresss (
    `id`    bigint,
    `address_name`  varchar(200),
    `send_status`   int(1),
    `receive_status`    int(1),
    `name`  varchar(64),
    `phone`	    varchar(64),
    `province`   varchar(64),
    `city`  varchar(64),
    `region`    varchar(64),
    `detail_address`    varchar(64),
    PRIMARY KEY(`id`)
);
```

## 2. Insert some random data to oms_company_address table
```
insert oms_company_addresss (id, address_name, send_status,receive_status,name,phone,province,city,region,detail_address) VALUES
    (1, "Centre0", 0, 0, "M", "5555555555", "PA","Pittsburgh","Pittsburgh", "apt 1234"),
    (2, "Centre1", 0, 0, "M", "5555555555", "PA","Pittsburgh","Pittsburgh", "apt 1234"),
    (3, "Centre2", 0, 0, "M", "5555555555", "PA","Pittsburgh","Pittsburgh", "apt 1234"),
    (4, "Centre3", 1, 0, "M", "5555555555", "PA","Pittsburgh","Pittsburgh", "apt 1234"),
    (5, "Centre4", 1, 1, "M", "5555555555", "PA","Pittsburgh","Pittsburgh", "apt 1234");

```

## 3. Write a SQL query to fetch all data from oms_company_address `table
```
Select * from oms_company_addresss;
```

## 4. Write a SQL query to fetch top 3 records from oms_company_address table
``` 
   Select * from oms_company_addresss order by  id desc LIMIT 3;
```

## 5. Update oms_company_address table to set all phone to 666-6666-8888
```
UPDATE oms_company_addresss
SET phone = "666-6666-8888";
```
## 6. Delete one entry from oms_company_address table
```
DELETE  FROM oms_company_addresss WHERE id = 1;
```

# NoSQL - MongoDB
## 1. Create  test DB 
```
use test
```

## 2. Create  oms_company_address  collection  (method: createCollection() )
```
db.createCollection("oms_company_address")
```

## 3. Insert few random entries to  oms_company_address  collection (method: insert() )
```
db.oms_company_address.insert([
{
id: 1,
address_name: "company1",
send_status: 0,
receive_status: 0,
name: "M",
phone: "2222222222",
province: "PA",
city: "Pittsburgh",
region: "Pittsburgh",
detailed_address: "qqqqq"
},
{
id: 2,
address_name: "company2",
send_status: 0,
receive_status: 0,
name: "MM",
phone: "1111111111",
province: "PA",
city: "Pittsburgh",
region: "Pittsburgh",
detailed_address: "wwwww"
}
])
```
## 4. Read one entry from  oms_company_address  collection (method: find() )
```
db.oms_company_address.find({"id":1})
```

## 5. Read all entries from  oms_company_address  collection (method: find() )
```
db.oms_company_address.find()
```

## 6. Update one entry from  oms_company_address collection (method: update() or save() )
```
db.oms_company_address.update(
    { id: 2 }, 
    {
        $set: { 
            receive_status: 1,
        }
    }
)
```

## 7. Remove one entry from  oms_company_address collection (method: remove() )
```
db.oms_company_address.remove({"id":2})
```

# API Design
## 1. find the customer's payments
* GET /api/v1/customer/{id}/payment

## 2. Find the customer's history orders from 10/10/2022 to 10/24/2022
* GET /api/v1/customer/{id}/orders?start-date=10-10-2022&end-date=10-24-2022

## 3. Find the customer's delivery addresses
* GET /api/v1/customer/{id}/delivery-addresses

## 4. If I also want to get customer's default payment and default delivery address, what kind of the API (URL) should be?
* GET /api/v1/customer/default-payment
* GET /api/v1/customer/default-delivery-addresses

## 6. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE.
```
Get User's bio
GET /api/v1/user/{id}/bio

Modify user's info
PUT /api/v1/user/{id}/bio

Get all posts form the user
GET /api/v1/user/{id}/posts

Get a post form the user
GET /api/v1/user/{id}/posts?post-id={pid}

Create new post for the user
POST /api/v1/user/{id}/posts

Delete a user's post
DELETE /api/v1/user/{id}/posts?post-id={pid}

Get comments of a post
GET /api/v1/posts/{pid}/comments

Post a comment on post
POST /api/v1/posts/{pid}/comments?comment-id={cid}
```
