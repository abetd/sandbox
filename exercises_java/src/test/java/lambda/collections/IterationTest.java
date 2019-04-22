package lambda.collections;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;


/**
 * Iteration を Lambda で実装
 */
public class IterationTest {

    static final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Lucy", "Sara", "Scott");

    @Test
    @Disabled("print で動作確認したのでスキップ")
    @DisplayName("iteration いろいろ")
    void iterationExamples() {
        // 古いfor文
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }

        // 拡張for文
        for (String name : friends) {
            System.out.println(name);
        }

        // forEach で Consumer
        friends.forEach(new Consumer<String>() {
            @Override
            public void accept(final String name) {
                System.out.println(name);
            }
        });

        // forEach でシンプルに
        friends.forEach(name -> System.out.println(name));

        // もっとシンプルに
        friends.forEach(System.out::println);
    }

    @Test
    @DisplayName("リストを結合")
    void join() {
        String expected = "Brian, Nate, Neal, Lucy, Sara, Scott";
        assertEquals(expected, String.join(", ", friends));
        assertEquals(expected, friends.stream().collect(Collectors.joining(", ")));

        String expectedUpperCase = "BRIAN, NATE, NEAL, LUCY, SARA, SCOTT";
        String actualUpperCase = friends.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        assertEquals(expectedUpperCase, actualUpperCase);
    }
}
