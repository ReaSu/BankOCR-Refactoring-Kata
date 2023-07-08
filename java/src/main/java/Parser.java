import java.util.ArrayList;
import java.util.List;

class Parser {

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

	private Digit nextInputDigit(int line, int position, String[] input) {
		Digit inputDigit = new Digit();
		for (int i = 0; i < CHAR_HEIGHT; i++) {
			inputDigit.add(input[line + i].substring(CHAR_WIDTH * position, CHAR_WIDTH * position + CHAR_WIDTH));
		}
		return inputDigit;
	}
}
