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
    public void middleTest1() {
        String inputText = "сто сорок второй";
        int result = StringNumberParser.parse(inputText);
        assertEquals("Wrong string number parse", 142, result);
    }

    @Test
    public void middleTest2() {
        String inputText = "двести тридцать четвёртая";
        int result = StringNumberParser.parse(inputText);
        assertEquals("Wrong string number parse", 234, result);
    }

    @Test
    public void middleTest3() {
        String inputText = "сто восемнадцатая";
        int result = StringNumberParser.parse(inputText);
        assertEquals("Wrong string number parse", 118, result);
    }

    @Test
    public void middleTest4() {
        String inputText = "сто двадцатая";
        int result = StringNumberParser.parse(inputText);
        assertEquals("Wrong string number parse", 120, result);
    }

    @Test
    public void middleTest5() {
        String inputText = "сто десятая";
        int result = StringNumberParser.parse(inputText);
        assertEquals("Wrong string number parse", 110, result);
    }

    @Test
    public void middleTest6() {
        String inputText = "сто пятая";
        int result = StringNumberParser.parse(inputText);
        assertEquals("Wrong string number parse", 105, result);
    }

    @Test
    public void middleTest7() {
        String inputText = "двести девятая";
        int result = StringNumberParser.parse(inputText);
        assertEquals("Wrong string number parse", 209, result);
    }

    @Test
    public void failTest1() {
        String inputText = null;
        int result = StringNumberParser.parse(inputText);
        assertEquals("Wrong string number parse", -1, result);
    }

    @Test
    public void failTest2() {
        String inputText = "   ";
        int result = StringNumberParser.parse(inputText);
        assertEquals("Wrong string number parse", -1, result);
    }

    @Test
    public void failTest3() {
        String inputText = "тест_строка";
        int result = StringNumberParser.parse(inputText);
        assertEquals("Wrong string number parse", -1, result);
    }

    @Test
    public void failTest4() {
        String inputText = "сто сорок тест";
        int result = StringNumberParser.parse(inputText);
        assertEquals("Wrong string number parse", 140, result);
    }

    @Test
    public void failTest5() {
        String inputText = "сто десятая пятая";
        int result = StringNumberParser.parse(inputText);
        assertEquals("Wrong string number parse", -1, result);
    }
}
