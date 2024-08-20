//package com.chuwa.mongoblog.service.Impl;
//
//
//import com.chuwa.mongoblog.dto.PostDto;
//import com.chuwa.mongoblog.entity.Post;
//import com.chuwa.mongoblog.repository.PostRepository;
//import com.chuwa.mongoblog.service.PostService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class PostServiceImpl implements PostService {
//    @Autowired
//    private PostRepository postRepository;
//
//    PostServiceImpl(){
//    }
//
//    PostServiceImpl(PostRepository postRepo){
//        this.postRepository = postRepo;
//    }
//
//    /**
//     * 为什么将PostDto -> Post -> PostDto
//     * 1. 数据传输与持久化分离：
//     * DTO（Data Transfer Object）：用于在不同层（例如Controller和Service层）之间传输数据。它通常只包含必要的字段，可能没有数据库相关的注解和约束。
//     * 实体对象（Entity）：用于映射数据库表，包含所有数据库相关的注解和约束。实体对象直接与数据库交互。
//     * 2. 保持数据模型一致性：
//     * 当接收到客户端请求时，数据以DTO的形式传输，这样可以防止暴露数据库模型的细节。
//     * 在业务逻辑中，需要将DTO转换为实体对象，进行持久化操作，以便与数据库交互。
//     * 持久化操作完成后，将实体对象转换回DTO，返回给客户端。这有助于控制返回的数据内容，确保数据模型的一致性。
//     * 3. 解耦业务逻辑和数据库层：
//     * DTO和实体对象的分离使得业务逻辑与数据库层解耦。如果数据库模型发生变化，只需要修改实体对象和Repository层，而不影响Service和Controller层的逻辑。
//     * DTO的使用也使得可以轻松地添加或删除字段，而不影响数据库层的结构。
//     * @param postDto
//     * @return
//     */
//    @Override
//    public PostDto createPost(PostDto postDto) {
//        //step 1: create object "Post"
//        Post post = new Post();
//        post.setId(postDto.getId());
//        post.setTitle(postDto.getTitle());
//        post.setContent(postDto.getContent());
//        post.setDescription(postDto.getDescription());
//
//        // step 2: connect to DB and save object "Post", 持久化Post实体对象
//        Post savedPost = postRepository.save(post);
//        // 将持久化后的Post实体对象转换回PostDto
//        PostDto response = new PostDto();
//        response.setId(savedPost.getId());
//        response.setTitle(savedPost.getTitle());
//        response.setContent(savedPost.getContent());
//        response.setDescription(savedPost.getDescription());
//
//        return response;
//    }
//
//    @Override
//    public PostDto getPostById(Long postId) {
//        // getById 方法可能会立即引发 EntityNotFoundException 异常，而 findById 方法会返回 Optional，适合用来处理缺失的记录。
////        Post post = postRepository.getById(postId);  // 用它 mockito test就错误。。
//        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));;
//        PostDto response = new PostDto();
//        response.setId(post.getId());
//        response.setTitle(post.getTitle());
//        response.setContent(post.getContent());
//        response.setDescription(post.getDescription());
//        return response;
//    }
//
//    @Override
//    public PostDto updatePost(PostDto newPost, long postId) {
//        return null;
//    }
//
//    @Override
//    public PostDto deleteById(Long postId) {
//        return null;
//    }
//
//    @Override
//    public List<PostDto> getAllPost() {
//        List<Post> posts = postRepository.findAll();
//        List<PostDto> postDtos = posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
//        return postDtos;
//    }
//
//
//    private PostDto mapToDTO(Post post) {
//        PostDto postDto = new PostDto();
//        postDto.setId(post.getId());
//        postDto.setTitle(post.getTitle());
//        postDto.setDescription(post.getDescription());
//        postDto.setContent(post.getContent());
//
//        return postDto;
//    }
//
//    private Post mapToEntity(PostDto postDto){
//        Post post = new Post();
//        post.setId(postDto.getId());
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
//
//        return post;
//    }
//
//
//}
