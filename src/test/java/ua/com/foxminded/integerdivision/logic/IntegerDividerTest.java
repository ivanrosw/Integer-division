package ua.com.foxminded.integerdivision.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerDividerTest {

    @Test
    void TestPrintDivision_513_2_ShouldPrint() {
        IntegerDivider integerDivider = new IntegerDivider();
        String expected = "_513|2\n" +
                " 4  |---\n" +
                " -- |256\n" +
                "_11\n" +
                " 10\n" +
                " --\n" +
                " _13\n" +
                "  12\n" +
                "  --\n" +
                "   1";
        String actual = integerDivider.printDivision(513, 2);
        assertEquals(expected, actual);
    }

    @Test
    void TestPrintDivision_Minus513_2_ShouldPrint() {
        IntegerDivider integerDivider = new IntegerDivider();
        String expected = "_-513|2\n" +
                "  4  |----\n" +
                "  -- |-256\n" +
                " _11\n" +
                "  10\n" +
                "  --\n" +
                "  _13\n" +
                "   12\n" +
                "   --\n" +
                "    1";
        String actual = integerDivider.printDivision(-513, 2);
        assertEquals(expected, actual);
    }

    @Test
    void TestPrintDivision_513_Minus2_ShouldPrint() {
        IntegerDivider integerDivider = new IntegerDivider();
        String expected = "_513|-2\n" +
                " 4  |----\n" +
                " -- |-256\n" +
                "_11\n" +
                " 10\n" +
                " --\n" +
                " _13\n" +
                "  12\n" +
                "  --\n" +
                "   1";
        String actual = integerDivider.printDivision(513, -2);
        assertEquals(expected, actual);
    }

    @Test
    void TestPrintDivision_Minus513_Minus2_ShouldPrint() {
        IntegerDivider integerDivider = new IntegerDivider();
        String expected = "_-513|-2\n" +
                "  4  |---\n" +
                "  -- |256\n" +
                " _11\n" +
                "  10\n" +
                "  --\n" +
                "  _13\n" +
                "   12\n" +
                "   --\n" +
                "    1";
        String actual = integerDivider.printDivision(-513, -2);
        assertEquals(expected, actual);
    }


    @Test
    void TestPrintDivision_513_22_ShouldPrint() {
        IntegerDivider integerDivider = new IntegerDivider();
        String expected = "_513|22\n" +
                " 44 |--\n" +
                " -- |23\n" +
                " _73\n" +
                "  66\n" +
                "  --\n" +
                "   7";
        String actual = integerDivider.printDivision(513, 22);
        assertEquals(expected, actual);
    }

    @Test
    void TestPrintDivision_Minus513_22_ShouldPrint() {
        IntegerDivider integerDivider = new IntegerDivider();
        String expected = "_-513|22\n" +
                "  44 |---\n" +
                "  -- |-23\n" +
                "  _73\n" +
                "   66\n" +
                "   --\n" +
                "    7";
        String actual = integerDivider.printDivision(-513, 22);
        assertEquals(expected, actual);
    }

    @Test
    void TestPrintDivision_Minus513_Minus22_ShouldPrint() {
        IntegerDivider integerDivider = new IntegerDivider();
        String expected = "_-513|-22\n" +
                "  44 |---\n" +
                "  -- |23\n" +
                "  _73\n" +
                "   66\n" +
                "   --\n" +
                "    7";
        String actual = integerDivider.printDivision(-513, -22);
        assertEquals(expected, actual);
    }

    @Test
    void TestPrintDivision_513_222_ShouldPrint() {
        IntegerDivider integerDivider = new IntegerDivider();
        String expected = "_513|222\n" +
                " 444|---\n" +
                " ---|2\n" +
                "  69";
        String actual = integerDivider.printDivision(513, 222);
        assertEquals(expected, actual);
    }

    @Test
    void TestPrintDivision_Minus513_222_ShouldPrint() {
        IntegerDivider integerDivider = new IntegerDivider();
        String expected = "_-513|222\n" +
                "  444|---\n" +
                "  ---|-2\n" +
                "   69";
        String actual = integerDivider.printDivision(-513, 222);
        assertEquals(expected, actual);
    }

    @Test
    void TestPrintDivision_513_Minus222_ShouldPrint() {
        IntegerDivider integerDivider = new IntegerDivider();
        String expected = "_513|-222\n" +
                " 444|----\n" +
                " ---|-2\n" +
                "  69";
        String actual = integerDivider.printDivision(513, -222);
        assertEquals(expected, actual);
    }

    @Test
    void TestPrintDivision_513_2222_ShouldThrowIllegalArgumentException() {
        IntegerDivider integerDivider = new IntegerDivider();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            integerDivider.printDivision(513,2222);
        });
    }

    @Test
    void TestPrintDivision_513_Minus2222_ShouldThrowIllegalArgumentException() {
        IntegerDivider integerDivider = new IntegerDivider();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            integerDivider.printDivision(513,-2222);
        });
    }

    @Test
    void TestPrintDivision_Minus513_Minus2222_ShouldThrowIllegalArgumentException() {
        IntegerDivider integerDivider = new IntegerDivider();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            integerDivider.printDivision(-513,-2222);
        });
    }

    @Test
    void TestPrintDivision_IntegerMAXVALUE_IntegerMAXVALUE_ShouldPrint() {
        IntegerDivider integerDivider = new IntegerDivider();
        String expected = "_2147483647|2147483647\n" +
                " 2147483647|----------\n" +
                " ----------|1\n" +
                "          0";
        String actual = integerDivider.printDivision(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(expected, actual);
    }

    @Test
    void TestPrintDivision_IntegerMAXVALUE_1_ShouldPrint() {
        IntegerDivider integerDivider = new IntegerDivider();
        String expected = "_2147483647|1\n" +
                " 2         |----------\n" +
                " --        |2147483647\n" +
                " _1\n" +
                "  1\n" +
                "  --\n" +
                "  _4\n" +
                "   4\n" +
                "   --\n" +
                "   _7\n" +
                "    7\n" +
                "    --\n" +
                "    _4\n" +
                "     4\n" +
                "     --\n" +
                "     _8\n" +
                "      8\n" +
                "      --\n" +
                "      _3\n" +
                "       3\n" +
                "       --\n" +
                "       _6\n" +
                "        6\n" +
                "        --\n" +
                "        _4\n" +
                "         4\n" +
                "         --\n" +
                "         _7\n" +
                "          7\n" +
                "          --\n" +
                "           0";
        String actual = integerDivider.printDivision(Integer.MAX_VALUE, 1);
        assertEquals(expected, actual);
    }

    @Test
    void TestPrintDivision_0_Number_ShouldThrowIllegalArgumentException() {
        IntegerDivider integerDivider = new IntegerDivider();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            integerDivider.printDivision(0,222);
        });
    }

    @Test
    void TestPrintDivision_Number_0_ShouldThrowIllegalArgumentException() {
        IntegerDivider integerDivider = new IntegerDivider();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            integerDivider.printDivision(513,0);
        });
    }
}
