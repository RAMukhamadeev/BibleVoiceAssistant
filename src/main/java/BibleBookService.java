import java.util.ArrayList;
import java.util.HashMap;

public class BibleBookService {
    private static ArrayList<BibleBook> allBooks;

    private static ArrayList<BibleBook> getAllBooks() {
        if (allBooks == null) {
            allBooks = JacksonSerializer.getBooksDictionary();
        }
        return allBooks;
    }

    public static HashMap<String, BibleBook> getBookNamesMap() {
        ArrayList<BibleBook> bibleBooks = getAllBooks();
        HashMap<String, BibleBook> bookNamesMap = new HashMap<>();
        for (BibleBook book : bibleBooks) {
            for (String bookName : book.allNames) {
                bookNamesMap.put(bookName, book);
            }
        }

        return bookNamesMap;
    }
}
