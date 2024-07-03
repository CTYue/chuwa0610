# AnnoTations
### @Test
- To run Junit Tests
```java
    @Test
    public void testArrays() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
    //...
    }
```
### @Override
- To override a method from inherited class
```java
    @Override
    public PostDto createPost(PostDto postDto) {
    // step1 create object "Post"
    }
```
## @Column
The @Column annotation is used to specify details about the columns in the database table that correspond to the annotated fields in the Java class. 
```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```
