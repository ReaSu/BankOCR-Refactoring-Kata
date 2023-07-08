import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Input consists of lines, each represented by a string.
 * 4 lines are an AccountNumber
 * each AccountNumber is made up of 9 inputDigits
 * each inputDigit is 4 chars wide (and 4 lines tall - cf. inputNumber)
 * 
 * Output consists of accountNumbers plus a marker
 * each accountNumber is made up of 9 digits (or ?)
 * a marker is 4 chars wide, and either empty (spaces) or " ILL" if accountNumber contains at least one "?"
 * 
 * There is a list of known character representations, input is compared to those for translation.
 */

public class Ocr {
	public static List<String> parse(String... lines) {
		List<String> result = new ArrayList<String>();
		InputParser parser = new InputParser();
		Translator translator = new Translator();
		List<AccountNumber> inputAccountNumbers = parser.segment(lines);
		for (AccountNumber inputAccountNumber : inputAccountNumbers) {
			result.add(translator.translate(inputAccountNumber));
		}
		return result;
	}

}

class Translator {
	private List<KnownChars> knownChars = new ArrayList<KnownChars>();

	public Translator() {
		initBlueprints();
	}

	void initBlueprints() {
		KnownChars zero = new Zero();
		KnownChars one = new One();
		KnownChars two = new Two();
		KnownChars three = new Three();
		KnownChars four = new Four();
		KnownChars five = new Five();
		KnownChars six = new Six();
		KnownChars seven = new Seven();
		KnownChars eight = new Eight();
		KnownChars nine = new Nine();
		knownChars.addAll(Arrays.asList(zero, one, two, three, four, five, six, seven, eight, nine));
	}

	String translate(AccountNumber input) {
		StringBuilder sb = new StringBuilder();
		String marker = "    ";
		for (InputDigit digit : input) {
			sb.append(parseNext(digit));
		}
		if (isIllegal(sb)) {
			marker = " ILL";
		}
		sb.append(marker);
		return sb.toString();
	}

	private String parseNext(InputDigit inputDigit) {
		String appendage = "?";
		for (KnownChars current : knownChars) {
			int foundDigit = current.correspondsTo(inputDigit);
			if (foundDigit != -1) {
				appendage = String.valueOf(foundDigit);
				break;
			}
		}
		return appendage;
	}

	private boolean isIllegal(StringBuilder sb) {
		return sb.indexOf("?") > -1;
	}
}

class InputParser {

	private static final int ACCOUNT_NUMBER_LENGTH = 9;
	private static final int CHAR_HEIGHT = 4;
	private static final int CHAR_WIDTH = 4;

	List<AccountNumber> segment(String[] input) {
		List<AccountNumber> accountNumbers = new ArrayList<AccountNumber>();
		for (int line = 0; line < input.length; line += CHAR_HEIGHT) {
			AccountNumber accountNumber = new AccountNumber();
			for (int digit = 0; digit < ACCOUNT_NUMBER_LENGTH; ++digit) {
				accountNumber.add(nextInputDigit(line, digit, input));

			}
			accountNumbers.add(accountNumber);
		}
		return accountNumbers;
	}

	private InputDigit nextInputDigit(int line, int position, String[] input) {
		InputDigit inputDigit = new InputDigit();
		for (int i = 0; i < CHAR_HEIGHT; i++) {
			inputDigit.add(input[line + i].substring(CHAR_WIDTH * position, CHAR_WIDTH * position + CHAR_WIDTH));
		}
		return inputDigit;
	}
}
