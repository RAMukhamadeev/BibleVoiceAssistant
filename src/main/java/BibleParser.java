import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class BibleParser {
    private static final String BOOK_MARK = "Книга ";
    private static final String CHAPTER_MARK = "Глава ";
    private static final String PSALM_MARK = "Псалом ";
    private static final String PATH_TO_BIBLE_MAP = "src/main/resources/Bible/bible.map";
    private static final String PATH_TO_BIBLE_TEXT = "src/main/resources/Bible/bible.txt";

    public BibleParser() {
    }

    public static HashMap<String, String> getBibleMapFromText() {
        HashMap<String, String> bibleMap = new HashMap<>();

        try {
            List<String> bibleLines = Files.readAllLines(Paths.get(PATH_TO_BIBLE_TEXT));

            String currentBook = "";
            int currentChapterNumber = 0;
            int currentVerseNumber;
            for (String line : bibleLines) {
                if (line == null) {
                    continue;
                }
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                if (line.startsWith(BOOK_MARK)) {
                    currentBook = line.substring(BOOK_MARK.length()).toLowerCase();
                    continue;
                }

                if (line.startsWith(CHAPTER_MARK)) {
                    String chapterNumberStr = line.substring(CHAPTER_MARK.length());
                    currentChapterNumber = Integer.parseInt(chapterNumberStr);
                    continue;
                }
                if (line.startsWith(PSALM_MARK)) {
                    String chapterNumberStr = line.substring(PSALM_MARK.length());
                    currentChapterNumber = Integer.parseInt(chapterNumberStr);
                    continue;
                }

                int firstWhitespacePosition = line.indexOf(' ');
                String currentVerseNumberStr = line.substring(0, firstWhitespacePosition);
                currentVerseNumber = Integer.parseInt(currentVerseNumberStr);

                String currentVerse = line.substring(firstWhitespacePosition + 1);

                String key = currentBook + " " + currentChapterNumber + ":" + currentVerseNumber;
                bibleMap.put(key, currentVerse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bibleMap;
    }

    public static void saveBibleMapToFile(HashMap<String, String> bibleMap) {
        try {
            FileOutputStream fos = new FileOutputStream(PATH_TO_BIBLE_MAP);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bibleMap);
            oos.close();
            fos.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, String> getBibleMapFromFile() {
        HashMap<String, String> bibleMap = new HashMap<>();
        try {
            FileInputStream fis = new FileInputStream(PATH_TO_BIBLE_MAP);
            ObjectInputStream ois = new ObjectInputStream(fis);
            bibleMap = (HashMap) ois.readObject();
            ois.close();
            fis.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return bibleMap;
    }

    public static void readTextFileAndSaveAsMapFile() {
        HashMap<String, String> bibleMap = BibleParser.getBibleMapFromText();
        BibleParser.saveBibleMapToFile(bibleMap);
    }
}
