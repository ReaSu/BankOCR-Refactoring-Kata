import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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

	static List<Blueprint> initBlueprints() {
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
		return Arrays.asList(zero, one, two, three, four, five, six, seven, eight, nine);
	}

	public static List<String> parse(String... lines) {
		blueprints.addAll(initBlueprints());
		final List<String> result = new ArrayList<String>();
		List<InputNumber> inputNumbers = new ArrayList<InputNumber>();
		for (int i = 0; i < lines.length; i += 4) {
			InputNumber inputNumber = new InputNumber();
			for (int pos = 0; pos < 9; ++pos) {
				inputNumber.add(nextInputDigit(i, pos, lines));

			}
			inputNumbers.add(inputNumber);
		}
		for (InputNumber inputNumber : inputNumbers) {
			StringBuilder sb = new StringBuilder();
			String marker = "    ";
			for (InputDigit inputDigit : inputNumber) {
				sb.append(parseNextDigit(inputDigit));
			}
			if (sb.indexOf("?") > -1) {
				marker = " ILL";
			}
			sb.append(marker);
			result.add(sb.toString());
		}

		return result;
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

class InputDigit{
	ArrayList<String> input = new ArrayList<String>();

	public void add(String partialLine) {
		input.add(partialLine);

	}

	public String get(int lineNumber) {
		return input.get(lineNumber);
	}

}

class InputNumber implements Iterable<InputDigit>{
	ArrayList<InputDigit> inputAccountNumber = new ArrayList<InputDigit>();

	public void add(InputDigit inputDigit) {
		inputAccountNumber.add(inputDigit);

	}

	@Override
	public Iterator<InputDigit> iterator() {
		
		return new InputIterator(inputAccountNumber);
	}
	

	public int size() {
		return inputAccountNumber.size();
	}

	public InputDigit get(int cursor) {
		return inputAccountNumber.get(cursor);
	}

	class InputIterator implements Iterator<InputDigit> {
		
		private int cursor;
		private ArrayList<InputDigit> inputNumber;
		
		public InputIterator(ArrayList<InputDigit> list) {
			cursor = 0;
			inputNumber = list;
		}
		
		@Override
		public boolean hasNext() {
			return (cursor < inputNumber.size());
		}
		
		@Override
		public InputDigit next() {
			return inputNumber.get(cursor++);
		}
		
	}
}
