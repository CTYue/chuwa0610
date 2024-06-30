### 1. create oms_company_address
```bash
    create table oms_company_address (
        id bigint primary key,
        address_name varchar(200),
        send_status int(1),
        receive_status int(1),
        name varchar(64),
        phone varchar(64),
        province varchar(64),
        city varchar(64),
        region varchar(64),
        detail_address varchar(200)
    )
```

### 2. Insert some random data to oms_company_address table
```bash
insert into oms_company_address(id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) values 
(1, "Oak Hollow", "1", "0", "kay", "111", "TX", "Frisco", "Collin", "Non"),
(2, "Oak Hollow", "1", "0", "sherry", "112", "TX", "Frisco", "Collin", "Non"),
(3, "Oak Hollow", "1", "0", "grace", "113", "TX", "Frisco", "Collin", "Non"),
(4, "Oak Hollow", "1", "0", "lucy", "140", "TX", "Frisco", "Collin", "Non")
```
### 3. Write a SQL query to fetch all data from oms_company_address `table
```bash
    select * 
    from oms_company_address
```
### 4. Write a SQL query to fetch top 3 records from oms_company_address table
```bash
    select * 
    from oms_company_address 
    limit 3;
```
### 5. Update oms_company_address table to set all phone to 666-6666-8888
```bash
    set sql_safe_updates = 0;
    update oms_company_address set phone = "666-6666-8888";
    set sql_safe_updates = 1;
```
### 6. Delete one entry from oms_company_address table
```bash
    delete from oms_company_address
    where id = 1;
```
### 7. (Optional)You can also try to create other tables that listed above

## MongoDB Non-SQL 

### 1. Create test DB
### 2. Create oms_company_address collection (method: createCollection() )
### 3. Insert few random entries to oms_company_address collection (method: insert() )
### 4. Read one entry from oms_company_address collection (method: find() )
### 5. Read all entries from oms_company_address collection (method: find() )
### 6. Updateoneentryfromoms_company_addresscollection(method:update()orsave()) 
### 7. Removeoneentryfromoms_company_addresscollection(method:remove())
### 8. (Optional)Youcanalsotrytocreateothertablesthatlistedabove
