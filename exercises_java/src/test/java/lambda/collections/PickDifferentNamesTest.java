package lambda.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 2.5 静的スコープとクロージャ
 * リスト friends から N または B から始まる名前の抽出をリファクタリング
 */
public class PickDifferentNamesTest {

    public static final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Lucy", "Sara", "Scott");

    @Test
    @DisplayName("重複したコード")
    public void before() {
        Predicate<String> startsWithN = name -> name.startsWith("N");
        Predicate<String> startsWithB = name -> name.startsWith("B");

        long countFriendsStartN = friends.stream().filter(startsWithN).count();
        long countFriendsStartB = friends.stream().filter(startsWithB).count();

        assertEquals(2, countFriendsStartN);
        assertEquals(1, countFriendsStartB);
    }

    public static Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }

    @Test
    @DisplayName("静的スコープで重複を排除")
    public void useStaticPredicate() {
        long countFriendsStartN = friends.stream().filter(checkIfStartsWith("N")).count();
        long countFriendsStartB = friends.stream().filter(checkIfStartsWith("B")).count();

        assertEquals(2, countFriendsStartN);
        assertEquals(1, countFriendsStartB);
    }

    @Test
    @DisplayName("Function インタフェースを使う")
    public void useFunction() {
        Function<String, Predicate<String>> startsWithLetter =
            (String letter) -> {
                Predicate<String> checdkStarts = (String name) -> name.startsWith(letter);
                return checdkStarts;
            };

        long countFriendsStartN = friends.stream().filter(startsWithLetter.apply("N")).count();
        long countFriendsStartB = friends.stream().filter(startsWithLetter.apply("B")).count();

        assertEquals(2, countFriendsStartN);
        assertEquals(1, countFriendsStartB);
    }

    @Test
    @DisplayName("Function をシンプルにリファクタリング")
    public void useFunctionSimple() {
        Function<String, Predicate<String>> startsWithLetter = letter -> name -> name.startsWith(letter);

        long countFriendsStartN = friends.stream().filter(startsWithLetter.apply("N")).count();
        long countFriendsStartB = friends.stream().filter(startsWithLetter.apply("B")).count();

        assertEquals(2, countFriendsStartN);
        assertEquals(1, countFriendsStartB);
    }
}
