package sandbox;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongTest {

    @Test
    @DisplayName("Longの割り算")
    void divide() {
        assertEquals(10L, 100L / 10L);
        assertEquals(16L, 100L / 6L);
    }

    @Test
    @DisplayName("Longの割り算2")
    void divide2() {
        assertEquals(10L, 100L / 10L);
        assertEquals(16L, 100L / 6L);
    }

}
