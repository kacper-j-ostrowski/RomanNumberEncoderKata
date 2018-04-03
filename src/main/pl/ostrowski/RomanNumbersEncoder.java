package main.pl.ostrowski;

import java.util.HashMap;

public class RomanNumbersEncoder {

    private final HashMap<Integer, String> dictionary;

    public RomanNumbersEncoder() {
        dictionary = new HashMap<>();
        initDictionary();
    }

    private void initDictionary() {
        dictionary.put(1000,"M");
        dictionary.put(500,"D");
        dictionary.put(100,"C");

        dictionary.put(50,"L");
        dictionary.put(10,"X");

        dictionary.put(5,"V");
        dictionary.put(1,"I");
    }


    public String encode(int number) {

        if(number < 1) {
            return null;
        }

        int firstDivider = 1000;
        int secondDivider = 500;
        int unit = 100;

        StringBuilder sb = new StringBuilder();

        while(number - 1000 >= 0) {
            sb.append(dictionary.get(1000));
            number = number - 1000;
        }

        while(unit >= 1) {

            while(number - (firstDivider - unit) >= 0) {
                sb.append(dictionary.get(unit));
                sb.append(dictionary.get(firstDivider));
                number = number - (firstDivider - unit);
            }

            if(number - secondDivider >= 0) {
                sb.append(dictionary.get(secondDivider));
                number = number - secondDivider;
                while(number - unit >= 0) {
                    sb.append(dictionary.get(unit));
                    number = number - unit;
                }
            }

            int tmp = firstDivider/10;
            firstDivider = secondDivider;
            secondDivider = tmp;

            if(firstDivider == unit) {
                unit = unit/10;
            }
        }
        return sb.toString();
    }
}