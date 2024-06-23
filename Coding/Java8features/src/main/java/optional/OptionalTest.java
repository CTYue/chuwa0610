package optional;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;
public class OptionalTest {
    void testOf() {
        String value = "Hello, Optional!";
        Optional<String> optional = Optional.of(value);
        assertTrue(optional.isPresent());
        assertEquals(value, optional.get());
    }

    void testOfNullable() {
        String value = null;
        Optional<String> optional = Optional.ofNullable(value);
        assertFalse(optional.isPresent());
    }

    void testEmpty() {
        Optional<String> optional = Optional.empty();
        assertFalse(optional.isPresent());
    }


    void testIfPresent() {
        Optional<String> optional = Optional.of("Hello, Optional!");
        optional.ifPresent(value -> assertEquals("Hello, Optional!", value));
    }

    void testOrElse() {
        Optional<String> optional = Optional.empty();
        String result = optional.orElse("Default value");
        assertEquals("Default value", result);
    }

    void testOrElseGet() {
        Optional<String> optional = Optional.empty();
        String result = optional.orElseGet(() -> "Default value");
        assertEquals("Default value", result);
    }

    void testOrElseThrow() {
        Optional<String> optional = Optional.empty();
        assertThrows(NoSuchElementException.class, optional::orElseThrow);
    }


    void testFilter() {
        Optional<Integer> optional = Optional.of(42);
        Optional<Integer> filtered = optional.filter(value -> value % 2 == 0);
        assertTrue(filtered.isPresent());
        assertEquals(Optional.of(42), filtered.get());

        filtered = optional.filter(value -> value % 2 != 0);
        assertFalse(filtered.isPresent());
    }

    void testMap() {
        Optional<String> optional = Optional.of("Hello, Optional!");
        Optional<Integer> mapped = optional.map(String::length);
        assertTrue(mapped.isPresent());
        assertEquals(Optional.of(16), mapped.get());
    }

    void testFlatMap() {
        Optional<String> optional = Optional.of("Hello, Optional!");
        Optional<Integer> flatMapped = optional.flatMap(value -> Optional.of(value.length()));
        assertTrue(flatMapped.isPresent());
        assertEquals(Optional.of(16), flatMapped.get());
    }
}
