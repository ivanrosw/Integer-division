package ua.com.foxminded.integerdivision.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerDivider {

    private static final String WHITESPACE = " ";
    private static final String VERTICAL_CANE = "|";
    private static final String MINUS = "_";
    private static final String HORIZONTAL_CANE = "-";
    private static final String NEXT_STRING_PATTERN = "\n";

    public String printDivision(int number, int divider) {
        if (divider == 0 || Math.abs(divider) > Math.abs(number)) {
            throw new IllegalArgumentException("Divider = 0 or |Divider| > |Number|");
        }

        int division = number / divider;

        List<String> remainderResults = new ArrayList<>();
        List<String> dividerMultipleResults = new ArrayList<>();
        calculateDivision(number, divider, remainderResults, dividerMultipleResults);

        int remainderResultsIndex = 1;
        int dividerMultipleResultsIndex = 1;
        int canesCount;
        int whitespaceCount;
        if (number < 0) {
            whitespaceCount = 2;
        } else {
            whitespaceCount = 1;
        }

        StringBuilder result = new StringBuilder();
        result.append(getHeader(number, divider, division, whitespaceCount, dividerMultipleResults.get(0)));

        for (int i = 1; i < dividerMultipleResults.size(); i++) {
            whitespaceCount = calculateWhitespaceCount(whitespaceCount, remainderResultsIndex, remainderResults);
            result.append(pad(WHITESPACE, whitespaceCount));
            result.replace(result.lastIndexOf(WHITESPACE), result.length(), MINUS);
            result.append(remainderResults.get(remainderResultsIndex) + NEXT_STRING_PATTERN);
            remainderResultsIndex++;

            result.append(pad(WHITESPACE, whitespaceCount));
            result.append(dividerMultipleResults.get(dividerMultipleResultsIndex) + NEXT_STRING_PATTERN);

            result.append(pad(WHITESPACE, whitespaceCount));
            canesCount = dividerMultipleResults.get(dividerMultipleResultsIndex).length();
            if (dividerMultipleResults.get(dividerMultipleResultsIndex).length() == 1) {
                canesCount++;
            }
            dividerMultipleResultsIndex++;
            result.append(pad(HORIZONTAL_CANE, canesCount));
            result.append(NEXT_STRING_PATTERN);
        }

        whitespaceCount = calculateWhitespaceCount(whitespaceCount, remainderResultsIndex, remainderResults);
        result.append(pad(WHITESPACE, whitespaceCount));
        result.append(remainderResults.get(remainderResultsIndex));

        return result.toString();
    }

    private void calculateDivision(int number, int divider, List<String> remainderResults, List<String> dividerMultipleResults) {
        int division = number / divider;

        List<String> numberDigits;
        List<String> divisionDigits;

        if(number < 0) {
            numberDigits = Arrays.asList(Integer.toString(number).substring(1).split(""));
        } else {
            numberDigits = Arrays.asList(Integer.toString(number).split(""));
        }
        if(division < 0) {
            divisionDigits = Arrays.asList(Integer.toString(division).substring(1).split(""));
        } else {
            divisionDigits = Arrays.asList(Integer.toString(division).split(""));
        }

        divider = Math.abs(divider);

        int remainder = Integer.parseInt(numberDigits.get(0));
        int numberDigitsIndex = 1;
        for (int i = 0; i < divisionDigits.size(); i++) {
            int dividerMultiple = divider * Integer.parseInt(divisionDigits.get(i));
            int divisionMultipleLength = Integer.toString(dividerMultiple).length();
            dividerMultipleResults.add(Integer.toString(dividerMultiple));

            StringBuilder remainderBuilder = new StringBuilder();
            if (remainder != 0) {
                remainderBuilder.append(remainder);
            }
            for (int remainderLength = remainderBuilder.length(); remainderLength < divisionMultipleLength; remainderLength++) {
                remainderBuilder.append(numberDigits.get(numberDigitsIndex));
                numberDigitsIndex++;
            }
            remainderResults.add(remainderBuilder.toString());

            remainder = Integer.parseInt(remainderBuilder.toString()) - dividerMultiple;

            if (i == divisionDigits.size() - 1) {
                remainderResults.add(Integer.toString(remainder));
            }
        }
    }

    private String getHeader(int number, int divider, int division, int whitespaceCount, String dividerMultiple) {
        StringBuilder result = new StringBuilder();
        int canesCount;
        result.append(MINUS + number + VERTICAL_CANE + divider + NEXT_STRING_PATTERN);

        number = Math.abs(number);
        result.append(pad(WHITESPACE, whitespaceCount));
        result.append(dividerMultiple);
        int remainderWhitespaceCount = Integer.toString(number).length() - dividerMultiple.length();
        result.append(pad(WHITESPACE, remainderWhitespaceCount));
        result.append(VERTICAL_CANE);
        if (Integer.toString(divider).length() > Integer.toString(division).length()) {
            canesCount = Integer.toString(divider).length();
        } else {
            canesCount = Integer.toString(division).length();
        }
        result.append(pad(HORIZONTAL_CANE, canesCount));
        result.append(NEXT_STRING_PATTERN);

        result.append(pad(WHITESPACE, whitespaceCount));
        canesCount = dividerMultiple.length();
        boolean canesCountIncremented = false;
        if (dividerMultiple.length() == 1) {
            canesCount++;
            canesCountIncremented = true;
        }
        result.append(pad(HORIZONTAL_CANE, canesCount));
        if (canesCountIncremented) {
            remainderWhitespaceCount--;
        }
        result.append(pad(WHITESPACE, remainderWhitespaceCount));
        result.append(VERTICAL_CANE + division + NEXT_STRING_PATTERN);

        return result.toString();
    }

    private String pad(String symbol, int amount) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            result.append(symbol);
        }
        return result.toString();
    }

    private int calculateWhitespaceCount(int whitespaceCount, int remainderResultIndex, List<String> remainderResults) {
        String remainder = remainderResults.get(remainderResultIndex);
        String previousRemainder = remainderResults.get(remainderResultIndex-1);
        if (remainder.length() == previousRemainder.length()) {
            whitespaceCount++;
        } else if (remainder.length() < previousRemainder.length()) {
            for (int i = remainder.length(); i < previousRemainder.length(); i++) {
                whitespaceCount++;
            }
        }
        return whitespaceCount;
    }
}
