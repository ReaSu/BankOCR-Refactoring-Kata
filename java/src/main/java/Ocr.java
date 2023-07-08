import java.util.ArrayList;
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
		Parser parser = new Parser();
		Translator translator = new Translator();
		
		List<AccountNumber> inputAccountNumbers = parser.segment(lines);
		
		for (AccountNumber inputAccountNumber : inputAccountNumbers) {
			result.add(translator.translate(inputAccountNumber));
		}
		
		return result;
	}

}
