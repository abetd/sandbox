package sandbox;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DoubleTest {

    @Test
    @DisplayName("doubleの割り算")
    void test() {
        double count = 0.0;
        count += 1.0 / 2.0;
        System.out.println(count);
    }
}
