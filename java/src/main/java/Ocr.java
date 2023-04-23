import java.util.List;
import java.util.ArrayList;

public class Ocr {

    public static List<String> parse(String... lines) {
        // TODO iterate over input bank account number
        final List<String> result = new ArrayList<String>();
        for (int i = 0; i < lines.length; i += 4) {
            analiseOcrNumber(result, i, lines);
        }
        return result;
    }

    private static void analiseOcrNumber(List<String> result, int i, String[] lines) {
        final char[] work = "             ".toCharArray();
        for (int pos = 0; pos < 9; ++pos) {
            compare_singleNumberFromInput_withNumerals(i, lines, work, pos);
        }
        result.add(new String(work));
    }

    private static void compare_singleNumberFromInput_withNumerals(int i, String[] lines, char[] work, int pos) {
        // TODO vergleicht einzelne Zahlen aus dem Input mit NUMERALS
        work[pos] = '?';
        for (int numeral = 0; numeral <= 9; ++numeral) {
            boolean ok = foo(i, lines, pos, numeral);
            // TODO wenn alle chars gleich waren (= keine chars unterschiedlich waren),
            //  wird die gefundene Ziffer an die position von work gespeichert.
            if (ok) {
                work[pos] = foo2(i, lines, pos, numeral);
            }
        }
        if (work[pos] == '?') {
            work[10] = 'I';
            work[11] = work[12] = 'L';
        }
    }

    private static boolean foo(int i, String[] lines, int pos, int numeral) {
        boolean ok = true;
        // TODO iteriert über die 4 Zeilen von Numeral bzw. lines
        for (int row = 0; row < 4; ++row) {
            // TODO iteriert über die 4 chars jeder Zeile von Numeral bzw. lines
            for (int col = 0; col < 4; ++col) {
                // TODO wenn die chars ungleich sind, wird ok auf false gesetzt
                if (Numerals.NUMERALS[numeral][row][col] != lines[i +row].charAt(4* pos +col))
                    ok = false;
            }
        }
        return ok;
    }

    private static char foo2(int i, String[] lines, int pos, int numeral) {
        boolean ok = true;
        // TODO iteriert über die 4 Zeilen von Numeral bzw. lines
        for (int row = 0; row < 4; ++row) {
            // TODO iteriert über die 4 chars jeder Zeile von Numeral bzw. lines
            for (int col = 0; col < 4; ++col) {
                // TODO wenn die chars ungleich sind, wird ok auf false gesetzt
                if (Numerals.NUMERALS[numeral][row][col] != lines[i +row].charAt(4* pos +col))
                    ok = false;
            }
        }
        char numeralString = Character.forDigit(numeral, 10);
        return ok ? numeralString : '?';
    }

}
