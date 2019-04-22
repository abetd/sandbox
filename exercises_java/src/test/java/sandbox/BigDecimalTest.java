package sandbox;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


public class BigDecimalTest {

    @Test
    @DisplayName("BigDecimal は Longの桁以上扱える")
    void max() {
        BigDecimal longMax = BigDecimal.valueOf(Long.MAX_VALUE);
        assertAll(
                () -> assertEquals(new BigDecimal("9223372036854775807"), longMax),
                () -> assertEquals(new BigDecimal("18446744073709551614"), longMax.multiply(BigDecimal.valueOf(2L))),
                () -> assertEquals(new BigDecimal("922337203685477580700000"), longMax.multiply(BigDecimal.valueOf(100000L)))
        );
    }

    @Test
    @DisplayName("moveRight, moveLeft で桁が変わる")
    void movePoint() {
        BigDecimal longMax = BigDecimal.valueOf(Long.MAX_VALUE);
        assertAll(
                () -> assertEquals(new BigDecimal("9223372036854775807"), longMax),
                () -> assertEquals(new BigDecimal("922337203685477580700"), longMax.movePointRight(2)),
                () -> assertEquals(new BigDecimal("92233720368547758.07"), longMax.movePointLeft(2))
        );
    }

    @Test
    void divide() {
        BigDecimal amount = new BigDecimal(10090);
        BigDecimal unit = new BigDecimal(100);
        int headcount = 10;
        assertEquals(3, unit.precision());
        BigDecimal actual = amount.divide(new BigDecimal(headcount), -2, BigDecimal.ROUND_UP);
        assertEquals(1100, actual.intValue());
    }
}
