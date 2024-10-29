package br.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P0067_AddBinary {

    public String addBinary(String a, String b) {

        var result = new StringBuilder();
        var aIndex = a.length() - 1;
        var bIndex = b.length() - 1;

        var carryValue = '0';
        var insertValue = '0';

        while (aIndex >= 0 || bIndex >=0) {

            var aDigit = aIndex < 0 ? '0' : a.charAt(aIndex--);
            var bDigit = bIndex < 0 ? '0' : b.charAt(bIndex--);

            if (aDigit == '0' && bDigit == '0') {
                insertValue = carryValue;
                carryValue = '0';
            } else if (aDigit == '1' && bDigit == '1') {
                insertValue = carryValue;
                carryValue = '1';
            } else {
                insertValue = carryValue == '1' ? '0' : '1';
            }
            result.insert(0, insertValue);
        }

        if (carryValue == '1') {
            result.insert(0, carryValue);
        }

        return result.toString();

    }

    public static class TestSolution {

        @ParameterizedTest
        @CsvSource({
                "11,   1,    100",
                "1010, 1011, 10101"
        })
        public final void testSuccess(String a, String b, String expected) {
            var problem = new P0067_AddBinary();
            var result = problem.addBinary(a, b);
            assertEquals(expected, result);
        }
    }
}
