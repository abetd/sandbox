package lambda.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 2.6 要素を一つ選択
 * 指定した文字から始まる名前の抽出を for文 と Lambda で比較
 */
public class PickAnElementTest {

    public static final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Rau", "Sara", "Scott");

    public String pickNameUseLoop(List<String> names, String startingLetter) {
        for (String name : names) {
            if (name.startsWith(startingLetter)) return name;
        }
        return "No name found";
    }

    public String pickNameUseLambda(List<String> names, String startingLetter) {
        Optional<String> foundName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();
        return foundName.orElse("No name found");
    }

    @Test
    @DisplayName("Loop を使った検索")
    public void useLoop() {
        String firstPickUpN = pickNameUseLoop(friends, "N");
        assertEquals("Nate", firstPickUpN);

        String firstPickUpZ = pickNameUseLoop(friends, "Z");
        assertEquals("No name found", firstPickUpZ);
    }

    @Test
    @DisplayName("Lambda を使った検索")
    public void useLambda() {
        String firstPickUpN = pickNameUseLambda(friends, "N");
        assertEquals("Nate", firstPickUpN);

        String firstPickUpZ = pickNameUseLambda(friends, "Z");
        assertEquals("No name found", firstPickUpZ);
    }

}
