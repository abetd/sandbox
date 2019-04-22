package sandbox;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LocalDateTest {

    @Test
    @DisplayName("isBefore, isAfter")
    void testBeforeAndAfter() {
        LocalDate date20180910 = LocalDate.of(2018, 9, 10);
        LocalDate date20180909 = LocalDate.of(2018, 9, 9);

        assertAll("after and before",
                () -> assertTrue(date20180909.isBefore(date20180910)),
                () -> assertFalse(date20180909.isAfter(date20180910))
        );
    }
}
