package test.pl.ostrowski;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import main.pl.ostrowski.RomanNumbersEncoder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class RomanNumbersEncoderShould {

    RomanNumbersEncoder romanNumbersEncoder;

    @Before
    public void setUp() {
        romanNumbersEncoder = new RomanNumbersEncoder();
    }

    @Test
    @Parameters ({
            "M, 1000",
            "MM, 2000",
            "MMMMMMMMMM, 10000"
    })
    public void encode_correctly_thousands(String expected, int number) {
        String romanNumber = romanNumbersEncoder.encode(number);
        assertEquals(expected, romanNumber);
    }


    @Test
    @Parameters ({
            "CM, 900"
    })
    public void encode_correctly_nine_hundreds(String expected, int number) {
        String romanNumber = romanNumbersEncoder.encode(number);
        assertEquals(expected, romanNumber);
    }


    @Test
    @Parameters ({
            "DCCC, 800",
            "DCC, 700",
            "DC, 600"
    })
    public void encode_correctly_over_five_hundreds(String expected, int number) {
        String romanNumber = romanNumbersEncoder.encode(number);
        assertEquals(expected, romanNumber);
    }


    @Test
    @Parameters ({
            "CCC, 300",
            "CC, 200",
            "C, 100",
            "CD, 400"
    })
    public void encode_correctly_below_five_hundreds(String expected, int number) {
        String romanNumber = romanNumbersEncoder.encode(number);
        assertEquals(expected, romanNumber);
    }

    @Test
    @Parameters ({
            "XC, 90",
            "LXXX, 80"
    })
    public void encode_correctly_over_five_tens(String expected, int number) {
        String romanNumber = romanNumbersEncoder.encode(number);
        assertEquals(expected, romanNumber);
    }


    @Test
    @Parameters ({
            "L, 50"
    })
    public void encode_correctly_fifty(String expected, int number) {
        String romanNumber = romanNumbersEncoder.encode(number);
        assertEquals(expected, romanNumber);
    }

    @Test
    @Parameters ({
            "XL, 40",
            "XXX, 30",
            "XX, 20",
            "X, 10"
    })
    public void encode_correctly_below_fifty(String expected, int number) {
        String romanNumber = romanNumbersEncoder.encode(number);
        assertEquals(expected, romanNumber);
    }

    @Test
    @Parameters ({
            "XV, 15",
            "XIX, 19",
            "XVIII, 18",
            "XVI, 16",
            "XIV, 14",
            "XIII, 13",
            "XI, 11"
    })
    public void encode_correctly_teens(String expected, int number) {
        String romanNumber = romanNumbersEncoder.encode(number);
        assertEquals(expected, romanNumber);
    }

    @Test
    @Parameters ({
            "I, 1",
            "III, 3",
            "IV, 4",
            "V, 5",
            "VI, 6",
            "VIII, 8",
            "IX, 9"
    })
    public void encode_correctly_below_ten(String expected, int number) {
        String romanNumber = romanNumbersEncoder.encode(number);
        assertEquals(expected, romanNumber);
    }

    @Test
    @Parameters ({
            "IV, 4",
            "VII, 7",
            "XIX, 19",
            "XL, 40",
            "XCV, 95",
            "CM, 900",
            "MXXV, 1025",
            "MCMXCV, 1995",
            "MM, 2000",
            "MCMLVI, 1956",
            "MMXI, 2011",
            "MMMDCCCLXXXVIII, 3888"

    })
    public void encode_correctly_random_numbers(String expected, int number) {
        String romanNumber = romanNumbersEncoder.encode(number);
        assertEquals(expected, romanNumber);
    }
}