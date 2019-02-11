import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void fizzbuzz() throws Exception {
        assertEquals("fizzbuzz", Main.fizzbuzz(15, ""));
    }
    @Test
    public void fizz() throws Exception {
        assertEquals("fizz", Main.fizzbuzz(3, ""));
    }
    @Test
    public void buzz() throws Exception {
        assertEquals("buzz", Main.fizzbuzz(5, ""));
    }
    @Test
    public void number() throws Exception {
        assertEquals("7", Main.fizzbuzz(7, ""));
    }
}