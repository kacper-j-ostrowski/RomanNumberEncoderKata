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
            "CM, 900",
            "CM, 999"
    })
    public void encode_correctly_nine_hundreads(String expected, int number) {
        String romanNumber = romanNumbersEncoder.encode(number);
        assertEquals(expected, romanNumber);
    }

}