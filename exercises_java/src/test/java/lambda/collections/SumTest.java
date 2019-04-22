package lambda.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * オブジェクトのリストの合計
 * stream().mapToLong().sum()
 */
public class SumTest {

    class Amount {
        long value;
        Amount(long value) {
            this.value = value;
        }
    }

    public List<Amount> amounts = Arrays.asList(
            new Amount(1000),
            new Amount(2000)
    );

    public long sum(List<Amount> amounts) {
        return amounts.stream().mapToLong(amount -> amount.value).sum();
    }

    @Test
    @DisplayName("Lambda を使ってリストの合計を計算")
    public void sumTest() {
        long actual = sum(amounts);
        assertEquals(3000, actual, "1000 + 2000");
    }
}
