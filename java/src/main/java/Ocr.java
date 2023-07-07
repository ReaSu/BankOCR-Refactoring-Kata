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
		for (int i = 0; i < lines.length; i += 4) {
			ArrayList<List<String>> inputDigits = new ArrayList<List<String>>();
			for (int pos = 0; pos < 9; ++pos) {
				inputDigits.add(nextInputDigit(i, pos, lines));
				
			}
			StringBuilder sb = new StringBuilder();
			String marker = "    ";
			for (List<String> inputDigit: inputDigits) {	
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

	private static String parseNextDigit(List<String> inputDigit) {
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

	private static List<String> nextInputDigit(int i, int pos, String... lines) {
		List<String> block = new ArrayList<String>();
		block.add(lines[i].substring(4 * pos, 4 * pos + 4));
		block.add(lines[i + 1].substring(4 * pos, 4 * pos + 4));
		block.add(lines[i + 2].substring(4 * pos, 4 * pos + 4));
		block.add(lines[i + 3].substring(4 * pos, 4 * pos + 4));
		return block;
	}
}

class Block {
	ArrayList<List<String>> blocks = new ArrayList<List<String>>();
	
}
