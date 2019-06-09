package sandbox;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    @Test
    void useOptionalString() {
        Optional<String> opt = Optional.of("test");

        final AtomicReference<String> upperCase = new AtomicReference<>();
        final AtomicInteger length = new AtomicInteger();

        opt.ifPresent(s -> {
            System.out.println(s);
            upperCase.set(s.toUpperCase());
            length.set(s.length());
        });

        assertEquals("TEST", upperCase.get());
        assertEquals(4, length.get());
    }

    @Test
    void updateAndGet() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 8, 13);
        final AtomicReference<Integer> count = new AtomicReference<>(0);
        for (Integer number: numbers) {
            Optional.of(number).ifPresent(n -> count.updateAndGet(c -> c + n));
        }
        assertEquals(32, count.get().intValue());
    }
}
