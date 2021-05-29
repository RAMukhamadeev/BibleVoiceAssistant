import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BibleVerseLocationParserTest {
    @Test
    public void simpleTest1() {
        String inputString = "евангелие от иоанна первая глава первый стих";
        String stdVerseLocation = BibleVerseLocationParser.getStdVerseLocation(inputString);

        assertEquals("Wrong bible verse location translation", "иоанна 1:1", stdVerseLocation);
    }

    @Test
    public void simpleTest2() {
        String inputString = "евангелие от иоанна третья глава шестнадцатый стих";
        String stdVerseLocation = BibleVerseLocationParser.getStdVerseLocation(inputString);

        assertEquals("Wrong bible verse location translation", "иоанна 3:16", stdVerseLocation);
    }

    @Test
    public void simpleTest3() {
        String inputString = "второе послание петра вторая глава двадцать второй стих";
        String stdVerseLocation = BibleVerseLocationParser.getStdVerseLocation(inputString);

        assertEquals("Wrong bible verse location translation", "2 петра 2:22", stdVerseLocation);
    }

    @Test
    public void failTest1() {
        String inputString = "тестовая строка";
        String stdVerseLocation = BibleVerseLocationParser.getStdVerseLocation(inputString);

        assertNull("Wrong bible verse location translation", stdVerseLocation);
    }


    @Test
    public void simpleTest4() {
        String inputString = "послание к филимону сорок первая глава пятьдесят третий стих";
        String stdVerseLocation = BibleVerseLocationParser.getStdVerseLocation(inputString);

        assertEquals("Wrong bible verse location translation", "филимону 41:53", stdVerseLocation);
    }

    @Test
    public void simpleTest5() {
        String inputString = "послание евреям двести седьмая глава одиннадцатый стих";
        String stdVerseLocation = BibleVerseLocationParser.getStdVerseLocation(inputString);

        assertEquals("Wrong bible verse location translation", "евреям 207:11", stdVerseLocation);
    }
}
