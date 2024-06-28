# HW6
## Exercise1
### 1. Create oms_company_address table
```
CREATE TABLE oms_company_address (
    id bigint PRIMARY KEY,
    address_name varchar(200),
    send_status int(1),
    receive_status int(1),
    name varchar(64),
    phone varchar(64),
    province varchar(64),
    city varchar(64),
    region varchar(64),
    detailed_address varchar(200)
);
```
![sql1.png](supportingImages/sql1.png)
### 2. Insert some random data to oms_company_address table
```
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detailed_address)
VALUES 
(1, 'OfficeA', 1, 0, 'Alice', '123-456-7890', 'California', 'Los Angeles', 'Westside', '123 Main St, Suite 100'),
(2, 'OfficeB', 0, 1, 'Bob', '987-654-3210', 'Texas', 'Dallas', 'Northside', '456 Oak St, Suite 200'),
(3, 'OfficeC', 1, 1, 'Charlie', '555-123-4567', 'New York', 'New York City', 'Eastside', '789 Pine St, Warehouse 3'),
(4, 'OfficeD', 1, 0, 'David', '444-987-6543', 'Florida', 'Miami', 'Southside', '101 Maple St, Suite 300');
```
![sql2.png](supportingImages%2Fsql2.png)
### 3. Write a SQL query to fetch all data from oms_company_address `table
```
SELECT * FROM oms_company_address;

```
![sql2.png](supportingImages%2Fsql2.png)
### 4. Write a SQL query to fetch top 3 records from oms_company_address table
```
SELECT * FROM oms_company_address LIMIT 3;
```
![sql3.png](supportingImages%2Fsql3.png)
### 5. Update oms_company_address table to set all phone to 666-6666-8888
```
UPDATE oms_company_address
SET phone = '666-6666-8888'
WHERE id IS NOT NULL;
```
![sql4.png](supportingImages%2Fsql4.png)
### 6. Delete one entry from oms_company_address table
```
DELETE FROM oms_company_address 
WHERE id = 4;
```
![sql5.png](supportingImages%2Fsql5.png)
## Exercise2
### 1. Create test DB
### 2. Create oms_company_address collection (method: createCollection() )
### 3. Insert few random entries to oms_company_address collection (method: insert() )
### 4. Read one entry from oms_company_address collection (method: find() )
### 5. Read all entries from oms_company_address collection (method: find() )
### 6. Update one entry from oms_company_address collection (method: update() or save() )
### 7. Remove one entry from oms_company_address collection (method: remove() )