package lambda.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 2.2 リストの変換
 */
public class TransformTest {

    public static final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Lucy", "Sara", "Scott");

    @Test
    @DisplayName("拡張for文")
    public void extensionForLoop() {
        List<String> expected = Arrays.asList("BRIAN", "NATE", "NEAL", "LUCY", "SARA", "SCOTT");
        final List<String> uppercaseNames = new ArrayList<>();
        for (String name : friends) {
            uppercaseNames.add(name.toUpperCase());
        }
        assertIterableEquals(expected, uppercaseNames);
    }

    @Test
    @DisplayName("forEach")
    public void forEach() {
        List<String> expected = Arrays.asList("BRIAN", "NATE", "NEAL", "LUCY", "SARA", "SCOTT");
        List<String> uppercaseNames = new ArrayList<>();
        friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));
        assertIterableEquals(expected, uppercaseNames);
    }

    @Test
    @DisplayName("Lambda で")
    public void lambda() {
        List<String> expected = Arrays.asList("BRIAN", "NATE", "NEAL", "LUCY", "SARA", "SCOTT");
        List<String> uppercaseNames = new ArrayList<>();
        friends.stream()
                .map(name -> name.toUpperCase())
                .forEach(uppercaseName -> uppercaseNames.add(uppercaseName));
        assertIterableEquals(expected, uppercaseNames);
    }

    @Test
    @DisplayName("Lambda で メソッド参照")
    public void lambdaMethodReplace() {
        List<String> expected = Arrays.asList("BRIAN", "NATE", "NEAL", "LUCY", "SARA", "SCOTT");
        List<String> uppercaseNames = new ArrayList<>();
        friends.stream()
                .map(String::toUpperCase)
                .forEach(uppercaseName -> uppercaseNames.add(uppercaseName));
        assertIterableEquals(expected, uppercaseNames);
    }

    @Test
    @DisplayName("collect(Collectors.toList())でList.addを省略")
    public void lambdaCollect() {
        List<String> expected = Arrays.asList("BRIAN", "NATE", "NEAL", "LUCY", "SARA", "SCOTT");
        List<String> uppercaseNames = friends.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        assertIterableEquals(expected, uppercaseNames);
    }
}
