import java.util.ArrayList;

class InputDigit {
	ArrayList<String> input = new ArrayList<String>();

	public void add(String partialLine) {
		input.add(partialLine);

	}

	public String get(int lineNumber) {
		return input.get(lineNumber);
	}

}