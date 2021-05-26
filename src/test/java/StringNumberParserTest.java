import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringNumberParserTest {
    @Test
    public void simpleTest1() {
        String inputText = "первый";
        int result = StringNumberParser.parse(inputText);
        assertEquals("Wrong string number parse", 1, result);
    }

    @Test
    public void simpleTest2() {
        String inputText = "двенадцатый";
        int result = StringNumberParser.parse(inputText);
        assertEquals("Wrong string number parse", 12, result);
    }

    @Test
    public void simpleTest3() {
        String inputText = "сто сорок второй";
        int result = StringNumberParser.parse(inputText);
        assertEquals("Wrong string number parse", 142, result);
    }
}
