import java.util.ArrayList;
import java.util.HashMap;

public class StringNumberParser {
    private static HashMap<String, StringNumber> stringNumberDictionary;

    private static HashMap<String, StringNumber> getStringNumberDictionary() {
        if (stringNumberDictionary == null) {
            ArrayList<StringNumber> numbers = JacksonSerializer.getNumberDictionary();
            stringNumberDictionary = getStringNumbersMap(numbers);
        }
        return stringNumberDictionary;
    }

    private static HashMap<String, StringNumber> getStringNumbersMap(ArrayList<StringNumber> numbers) {
        HashMap<String, StringNumber> stringNumbersMap = new HashMap<>();
        for (StringNumber sn : numbers) {
            stringNumbersMap.put(sn.stringValue, sn);
        }
        return stringNumbersMap;
    }

    public static int parse(String inputText) {
        if (inputText == null || inputText.trim().isEmpty()) {
            return -1;
        }

        HashMap<String, StringNumber> stringNumberDictionary = getStringNumberDictionary();
        String[] tokens = inputText.split(" ");
        ArrayList<StringNumber> numbers = new ArrayList<>();
        for (String currToken : tokens) {
            if (stringNumberDictionary.containsKey(currToken)) {
                numbers.add(stringNumberDictionary.get(currToken));
            }
        }
        if (numbers.size() == 0) {
            return -1;
        }

        int res = 0;
        for (int i = 0; i < numbers.size(); i++) {
            StringNumber currNumber = numbers.get(i);
            if (i == 0) {
                res += currNumber.intValue;
            } else {
                StringNumber prevNumber = numbers.get(i - 1);
                if (prevNumber.allowRightAddition && prevNumber.getPow() > currNumber.getPow()) {
                    res += currNumber.intValue;
                } else {
                    res = -1;
                    break;
                }
            }
        }

        return res;
    }
}
