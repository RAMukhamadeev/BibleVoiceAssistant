import java.util.ArrayList;
import java.util.HashMap;

public class BibleVerseLocationParser {
    public static String getStdVerseLocation(String inputString) {
        inputString = inputString + " ";
        HashMap<String, BibleBook> bookNamesMap = BibleBookService.getBookNamesMap();

        int bestFindBookPosition = Integer.MAX_VALUE;
        String foundBibleBookName = null;
        for (String bookName : bookNamesMap.keySet()) {
            int currPosition = inputString.indexOf(bookName);
            if (currPosition != -1 && currPosition < bestFindBookPosition) {
                bestFindBookPosition = currPosition;
                foundBibleBookName = bookName;
            }
        }

        String CHAPTER_MARK = " глава ";
        String VERSE_MARK = " стих ";
        if (bestFindBookPosition != Integer.MAX_VALUE) {
            String bookName = bookNamesMap.get(foundBibleBookName).shortName;
            String chapterAndVerse = inputString.substring(bestFindBookPosition + foundBibleBookName.length());

            int chapterStringPosition = chapterAndVerse.indexOf(CHAPTER_MARK);
            int verseStringPosition = chapterAndVerse.indexOf(VERSE_MARK);
            if (chapterStringPosition != -1 && verseStringPosition != -1) {
                String chapterNumberString = chapterAndVerse.substring(0, chapterStringPosition);
                String verseNumberString = chapterAndVerse.substring(chapterStringPosition + CHAPTER_MARK.length(), verseStringPosition);
                int chapterNumber = StringNumberParser.parse(chapterNumberString);
                int verseNumber = StringNumberParser.parse(verseNumberString);
                String res = bookName + " " + chapterNumber + ":" + verseNumber;
                return res;
            }
        }

        return null;
    }
}
