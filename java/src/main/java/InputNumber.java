import java.util.ArrayList;
import java.util.Iterator;

class InputNumber implements Iterable<InputDigit> {
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
