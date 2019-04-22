package sandbox;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HelloworldTest {

    @Test
    @DisplayName("サンプル")
    void hello() {
        Helloworld sut = new Helloworld();
        assertEquals("Hello World.", sut.hello());
    }
}
