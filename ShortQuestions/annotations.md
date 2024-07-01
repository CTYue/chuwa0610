#Lombok
1. Database

    **@Entity:**
    - Marks a class as a JPA entity, representing a table in the database.   
    
   **@Table:**
   - Specifies the details of the table to which an entity is mapped, such as name and schema.

   **@Id:**
   - Marks a field as the primary key of an entity.

   **@GeneratedValue:**
   - Configures the strategy used to generate values for the primary key automatically.   

   **@Column:**
   - Configures the mapping between a field and a column in the database table, allowing customization of column name, length, nullable, etc.
   ```
    @Entity
    @Table(name = "posts")
    public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "title", unique = true, nullable = false)
        private String title;
        @Column(name = "content", nullable = false)
        private String content;
        @Column(name = "description", nullable = false)
        private String description;
    
        // Constructors, getters, setters, and other methods omitted for brevity
    }

   ```
2. @Repository
    - Data Access Object (DAO)
   ```
    @Repository
    public interface PostRepository extends JpaRepository<Post, Long> {
    // no code need here
    }
   ```
3. @Service
    - service component in the business layer.
    ```
    @Service
    public class PostServiceImpl implements PostService {

        @Autowired
        private PostRepository postRepository;
    
        @Override
        public PostDto createPost(PostDto postDto) {
            ...
        }
    }
    ```
4. @Controller
    - a controller component in the MVC (Model-View-Controller) architecture.
    ```
    @RestController
    @RequestMapping("/api/v1/posts")
    public class PostController {
    
        @Autowired
        private PostService postService;
    
        @PostMapping
        public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
            PostDto response = postService.createPost(postDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED) ;
        }
    }
    ```

5. @Autowired
    code in **Controller**
6. @PostMapping
   code in **Controller**
8. @RequestBody
   code in **Controller**