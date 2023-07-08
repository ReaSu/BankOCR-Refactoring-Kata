import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		Result result = new Result();
		for (Digit digit : input) {
			result.add(parseNext(digit));
		}
		result.addMarker();
		return result.toString();
	}

	private String parseNext(Digit inputDigit) {
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

}
