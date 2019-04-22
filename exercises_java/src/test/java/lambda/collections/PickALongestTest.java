package lambda.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 2.7 コレクションの集約(reduce)
 * リストから 一番長い文字列を抽出
 */
public class PickALongestTest {

    public static final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Lucy", "Sara", "Scott");

    public String longName(List<String>names) {
        Optional<String> aLongName = names.stream().reduce(
                (name1, name2) -> name1.length() >= name2.length() ? name1 : name2
        );
        return aLongName.orElse("No name found");
    }

    public String longName(List<String>names, String orElseName) {
        return names.stream().reduce(orElseName,
                (name1, name2) -> name1.length() >= name2.length() ? name1 : name2
        );
    }

    @Test
    @DisplayName("リストから一番長い名前を取得")
    public void longNameByList() {
        String actual = longName(friends);
        assertEquals("Brian",actual);
    }

    @Test
    @DisplayName("リストともう一つから一番長い名前を取得")
    public void longNameByListAndOne() {
        String actual = longName(friends, "HogeHoge");
        assertEquals("HogeHoge",actual);
    }
}
