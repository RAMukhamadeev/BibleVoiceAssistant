import java.util.ArrayList;
import java.util.HashMap;

public class StringNumberParser {

    private static HashMap<String, Integer> stringNumberMap;

    private static HashMap<String, Integer> getStringNumberMap() {
        if (stringNumberMap != null) {
            return stringNumberMap;
        }

        stringNumberMap = new HashMap<>();
        stringNumberMap.put("первый", 1);


        stringNumberMap.put("первая", 1);
        stringNumberMap.put("второй", 2);
        stringNumberMap.put("вторая", 2);
        stringNumberMap.put("третий", 3);
        stringNumberMap.put("третья", 3);
        stringNumberMap.put("четвёртый", 4);
        stringNumberMap.put("четвёртая", 4);
        stringNumberMap.put("пятый", 5);
        stringNumberMap.put("пятая", 5);
        stringNumberMap.put("шестой", 6);
        stringNumberMap.put("шестая", 6);
        stringNumberMap.put("седьмой", 7);
        stringNumberMap.put("седьмая", 7);
        stringNumberMap.put("восьмой", 8);
        stringNumberMap.put("восьмая", 8);
        stringNumberMap.put("девятый", 9);
        stringNumberMap.put("девятая", 9);

        stringNumberMap.put("десятый", 10);
        stringNumberMap.put("десятая", 10);
        stringNumberMap.put("одиннадцатый", 11);
        stringNumberMap.put("одиннадцатая", 11);
        stringNumberMap.put("двенадцатый", 12);
        stringNumberMap.put("двенадцатая", 12);
        stringNumberMap.put("тринадцатый", 13);
        stringNumberMap.put("тринадцатая", 13);
        stringNumberMap.put("четырнадцатый", 14);
        stringNumberMap.put("четырнадцатая", 14);
        stringNumberMap.put("пятнадцатый", 15);
        stringNumberMap.put("пятнадцатая", 15);
        stringNumberMap.put("шестнадцатый", 16);
        stringNumberMap.put("шестнадцатая", 16);
        stringNumberMap.put("семнадцатый", 17);
        stringNumberMap.put("семнадцатая", 17);
        stringNumberMap.put("восемнадцатый", 18);
        stringNumberMap.put("восемнадцатая", 18);
        stringNumberMap.put("девятнадцатый", 19);
        stringNumberMap.put("девятнадцатая", 19);

        stringNumberMap.put("двадцать", 20);
        stringNumberMap.put("двадцатый", 20);
        stringNumberMap.put("двадцатая", 20);
        stringNumberMap.put("тридцать", 30);
        stringNumberMap.put("тридцатый", 30);
        stringNumberMap.put("тридцатая", 30);
        stringNumberMap.put("сорок", 40);
        stringNumberMap.put("сороковой", 40);
        stringNumberMap.put("сороковая", 40);
        stringNumberMap.put("пятьдесят", 50);
        stringNumberMap.put("пятидесятый", 50);
        stringNumberMap.put("пятидесятая", 50);
        stringNumberMap.put("шестьдесят", 60);
        stringNumberMap.put("шестидесятый", 60);
        stringNumberMap.put("шестидесятая", 60);
        stringNumberMap.put("семьдесят", 70);
        stringNumberMap.put("семидесятый", 70);
        stringNumberMap.put("семидесятая", 70);
        stringNumberMap.put("восемдесят", 80);
        stringNumberMap.put("восьмидесятый", 80);
        stringNumberMap.put("восьмидесятая", 80);
        stringNumberMap.put("девяносто", 90);
        stringNumberMap.put("девяностый", 90);
        stringNumberMap.put("девяностая", 90);

        stringNumberMap.put("сто", 100);
        stringNumberMap.put("сотый", 100);
        stringNumberMap.put("сотая", 100);
        stringNumberMap.put("двести", 200);
        stringNumberMap.put("двухсотый", 200);
        stringNumberMap.put("двухсотая", 200);

        return stringNumberMap;
    }

    public static int parse(String inputText) {
        HashMap<String, Integer> stringToNumber = getStringNumberMap();

        String[] tokens = inputText.split(" ");
        ArrayList<Integer> integers = new ArrayList<>();
        for (String currToken : tokens) {
            if (stringToNumber.containsKey(currToken)) {
                integers.add(stringToNumber.get(currToken));
            }
        }

        return 0;
    }
}
