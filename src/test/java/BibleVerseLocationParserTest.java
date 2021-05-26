import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
    public void simpleTest4() {
        String inputString = "бытие сорок первая глава пятьдесят третий стих";
        String stdVerseLocation = BibleVerseLocationParser.getStdVerseLocation(inputString);

        assertEquals("Wrong bible verse location translation", "бытие 41:53", stdVerseLocation);
    }
}
