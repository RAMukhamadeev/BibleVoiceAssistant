import java.util.ArrayList;
import java.util.HashMap;

public class StringNumberParser {

    private static HashMap<String, StringNumber> getStringNumberDictionary() {
        ArrayList<StringNumber> numbers = new ArrayList<>();
        numbers.add(new StringNumber("первый", 1, false));
        numbers.add(new StringNumber("первая", 1, false));
        numbers.add(new StringNumber("второй", 2, false));
        numbers.add(new StringNumber("вторая", 2, false));
        numbers.add(new StringNumber("третий", 3, false));
        numbers.add(new StringNumber("третья", 3, false));
        numbers.add(new StringNumber("четвёртый", 4, false));
        numbers.add(new StringNumber("четвёртая", 4, false));
        numbers.add(new StringNumber("пятый", 5, false));
        numbers.add(new StringNumber("пятая", 5, false));
        numbers.add(new StringNumber("шестой", 6, false));
        numbers.add(new StringNumber("шестая", 6, false));
        numbers.add(new StringNumber("седьмой", 7, false));
        numbers.add(new StringNumber("седьмая", 7, false));
        numbers.add(new StringNumber("восьмой", 8, false));
        numbers.add(new StringNumber("восьмая", 8, false));
        numbers.add(new StringNumber("девятый", 9, false));
        numbers.add(new StringNumber("девятая", 9,false));

        numbers.add(new StringNumber("десятый", 10, false));
        numbers.add(new StringNumber("десятая", 10, false));
        numbers.add(new StringNumber("одиннадцатый", 11, false));
        numbers.add(new StringNumber("одиннадцатая", 11, false));
        numbers.add(new StringNumber("двенадцатый", 12, false));
        numbers.add(new StringNumber("двенадцатая", 12, false));
        numbers.add(new StringNumber("двенадцатая", 12, false));
        numbers.add(new StringNumber("тринадцатый", 13, false));
        numbers.add(new StringNumber("тринадцатая", 13,false));
        numbers.add(new StringNumber("четырнадцатый", 14,false));
        numbers.add(new StringNumber("четырнадцатая", 14,false));
        numbers.add(new StringNumber("пятнадцатый", 15,false));
        numbers.add(new StringNumber("пятнадцатая", 15,false));
        numbers.add(new StringNumber("шестнадцатый", 16,false));
        numbers.add(new StringNumber("шестнадцатая", 16,false));
        numbers.add(new StringNumber("семнадцатый", 17,false));
        numbers.add(new StringNumber("семнадцатая", 17,false));
        numbers.add(new StringNumber("восемнадцатый", 18,false));
        numbers.add(new StringNumber("восемнадцатая", 18,false));
        numbers.add(new StringNumber("девятнадцатый", 19,false));
        numbers.add(new StringNumber("девятнадцатая", 19,false));

        numbers.add(new StringNumber("двадцать", 20,true));
        numbers.add(new StringNumber("двадцатый", 20,false));
        numbers.add(new StringNumber("двадцатая", 20,false));
        numbers.add(new StringNumber("тридцать", 30,true));
        numbers.add(new StringNumber("тридцатый", 30,false));
        numbers.add(new StringNumber("тридцатая", 30,false));
        numbers.add(new StringNumber("сорок", 40,true));
        numbers.add(new StringNumber("сороковой", 40,false));
        numbers.add(new StringNumber("сороковая", 40,false));
        numbers.add(new StringNumber("пятьдесят", 50,true));
        numbers.add(new StringNumber("пятидесятый", 50,false));
        numbers.add(new StringNumber("пятидесятая", 50,false));
        numbers.add(new StringNumber("шестьдесят", 60,true));
        numbers.add(new StringNumber("шестидесятый", 60,false));
        numbers.add(new StringNumber("шестидесятая", 60,false));
        numbers.add(new StringNumber("семьдесят", 70,true));
        numbers.add(new StringNumber("семидесятый", 70,false));
        numbers.add(new StringNumber("семидесятая", 70,false));
        numbers.add(new StringNumber("восемдесят", 80,true));
        numbers.add(new StringNumber("восьмидесятый", 80,false));
        numbers.add(new StringNumber("восьмидесятая", 80,false));
        numbers.add(new StringNumber("девяносто", 90,true));
        numbers.add(new StringNumber("девяностый", 90,false));
        numbers.add(new StringNumber("девяностая", 90,false));

        numbers.add(new StringNumber("сто", 100,true));
        numbers.add(new StringNumber("сотый", 100,false));
        numbers.add(new StringNumber("сотая", 100,false));
        numbers.add(new StringNumber("двести", 200,true));
        numbers.add(new StringNumber("двухсотый", 200,false));
        numbers.add(new StringNumber("двухсотая", 200,false));

        HashMap<String, StringNumber> stringNumberDictionary = new HashMap<>();
        for (StringNumber sn : numbers) {
            stringNumberDictionary.put(sn.stringValue, sn);
        }
        return stringNumberDictionary;
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
                if (prevNumber.allowRightAddition && prevNumber.pow > currNumber.pow) {
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
