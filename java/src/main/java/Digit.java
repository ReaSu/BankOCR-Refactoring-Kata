import java.util.ArrayList;

class Digit {

	ArrayList<String> digit = new ArrayList<String>();

	public void add(String line) {
		digit.add(line);

	}

	public String get(int lineNumber) {
		return digit.get(lineNumber);
	}

}