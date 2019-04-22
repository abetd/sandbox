package lambda.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 要素の検索
 */
public class PickElementsTest {

    public static final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Lucy", "Sara", "Scott");

    @Test
    @DisplayName("拡張for文で検索")
    public void forLoop() {
        final List<String> startsWithN = new ArrayList<>();
        for (String name : friends) {
            if (name.startsWith("N")) {
                startsWithN.add(name);
            }
        }
        assertEquals(2, startsWithN.size());
    }

    @Test
    @DisplayName("Lambda で実装")
    public void lambda() {
        final List<String> startsWithN =
                friends.stream()
                        .filter(name -> name.startsWith("N"))
                        .collect(Collectors.toList());
        assertEquals(2, startsWithN.size());
    }

    @Test
    @DisplayName("Lambda : filter の判定を Predicate に変更")
    public void lambdaAndPredicate() {
        final Predicate<String> startsWithNFunction = name -> name.startsWith("N");
        final List<String> startsWithN =
                friends.stream()
                        .filter(startsWithNFunction)
                        .collect(Collectors.toList());
        assertEquals(2, startsWithN.size());
    }
}
