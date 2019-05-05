package sandbox;

import org.hashids.Hashids;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashidsTest {

    @Test
    @DisplayName("Hashidsテスト")
    void hashids() {
        Hashids hashids = new Hashids("this is my salt", 8, "ABCDEFGHJKLMNPQRSTUVWXYZ1234567890");
        String id = hashids.encode( 100);
        assertEquals("X7DYZMLK", id);

        id = hashids.encode( 1000000);
        assertEquals("DYEKZMJL", id);

        id = hashids.encode( 100000000);
        assertEquals("DY082661", id);
    }
}
