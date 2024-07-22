import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CommentServiceImplTest {

    @InjectMocks
    private CommentServiceImpl commentService;

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PostRepository postRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddComment() {
        Comment comment = new Comment();
        comment.setId(1L);
        comment.setText("Sample comment");
        when(commentRepository.save(any(Comment.class))).thenReturn(comment);

        Comment result = commentService.addComment(comment);

        assertNotNull(result);
        assertEquals(comment.getId(), result.getId());
        verify(commentRepository, times(1)).save(comment);
    }

    @Test
    void testDeleteComment() {
        Long commentId = 1L;
        doNothing().when(commentRepository).deleteById(commentId);

        commentService.deleteComment(commentId);

        verify(commentRepository, times(1)).deleteById(commentId);
    }

    @Test
    void testGetCommentsByPostId() {
        Long postId = 1L;
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment());
        when(commentRepository.findByPostId(postId)).thenReturn(comments);

        List<Comment> result = commentService.getCommentsByPostId(postId);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(commentRepository, times(1)).findByPostId(postId);
    }

    // Add more tests to cover all methods and edge cases
}
