package main.pl.ostrowski;

public class RomanNumbersEncoder {


    public String encode(int number) {

        StringBuilder sb = new StringBuilder();

        while(number - 1000 >= 0) {
            sb.append("M");
            number = number - 1000;
        }

        while(number - 900 >= 0) {
            sb.append("CM");
            number = number - 900;
        }

        return sb.toString();
    }
}
