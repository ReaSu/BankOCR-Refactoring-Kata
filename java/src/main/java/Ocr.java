import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Input consists of lines.
 * 4 lines are an inputNumber
 * each inputNumber is made up of 9 inputDigits (blocks)
 * each inputDigit is 4 chars wide (and 4 lines tall - cf. inputNumber)
 * 
 * Output consists of accountNumbers
 * each accountNumber is made up of 9 digits (or ?) plus a marker
 * a marker is 4 chars wide, and either empty (spaces) or " ILL" if accountNumber contains at least one "?"
 * 
 * There's a blueprint of each digit, input is compared to those for translation.
 */

public class Ocr {
	static List<Blueprint> blueprints = new ArrayList<Blueprint>();

	static void initBlueprints() {
		Blueprint zero = new NumberZero();
		Blueprint one = new NumberOne();
		Blueprint two = new NumberTwo();
		Blueprint three = new NumberThree();
		Blueprint four = new NumberFour();
		Blueprint five = new NumberFive();
		Blueprint six = new NumberSix();
		Blueprint seven = new NumberSeven();
		Blueprint eight = new NumberEight();
		Blueprint nine = new NumberNine();
		blueprints.addAll(Arrays.asList(zero, one, two, three, four, five, six, seven, eight, nine));
	}

	public static List<String> parse(String... lines) {
		initBlueprints();
		final List<String> result = new ArrayList<String>();
		List<InputNumber> inputNumbers = parseInput(lines);
		for (InputNumber inputNumber : inputNumbers) {
			result.add(translateNumber(inputNumber));
		}
		return result;
	}

	private static String translateNumber(InputNumber inputNumber) {
		StringBuilder sb = new StringBuilder();
		String marker = "    ";
		for (InputDigit inputDigit : inputNumber) {
			sb.append(parseNextDigit(inputDigit));
		}
		if (sb.indexOf("?") > -1) {
			marker = " ILL";
		}
		sb.append(marker);
		return sb.toString();
	}

	private static List<InputNumber> parseInput(String... lines) {
		List<InputNumber> inputNumbers = new ArrayList<InputNumber>();
		for (int i = 0; i < lines.length; i += 4) {
			InputNumber inputNumber = new InputNumber();
			for (int pos = 0; pos < 9; ++pos) {
				inputNumber.add(nextInputDigit(i, pos, lines));

			}
			inputNumbers.add(inputNumber);
		}
		return inputNumbers;
	}

	private static String parseNextDigit(InputDigit inputDigit) {
		String appendage = "?";
		for (Blueprint current : blueprints) {
			int foundDigit = current.correspondsTo(inputDigit);
			if (foundDigit != -1) {
				appendage = String.valueOf(foundDigit);
				break;
			}
		}
		return appendage;
	}

	private static InputDigit nextInputDigit(int i, int pos, String... lines) {
		InputDigit inputDigit = new InputDigit();
		inputDigit.add(lines[i + 0].substring(4 * pos, 4 * pos + 4));
		inputDigit.add(lines[i + 1].substring(4 * pos, 4 * pos + 4));
		inputDigit.add(lines[i + 2].substring(4 * pos, 4 * pos + 4));
		inputDigit.add(lines[i + 3].substring(4 * pos, 4 * pos + 4));
		return inputDigit;
	}
}
