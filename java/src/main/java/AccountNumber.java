import java.util.ArrayList;
import java.util.Iterator;

class AccountNumber implements Iterable<Digit> {
	ArrayList<Digit> accountNumber = new ArrayList<Digit>();

	public void add(Digit digit) {
		accountNumber.add(digit);
	}

	public Digit get(int cursor) {
		return accountNumber.get(cursor);
	}

	public int size() {
		return accountNumber.size();
	}
	
	@Override
	public Iterator<Digit> iterator() {
		return new AccountNumberIterator();
	}

	class AccountNumberIterator implements Iterator<Digit> {

		private int cursor;

		public AccountNumberIterator() {
			cursor = 0;
		}

		@Override
		public boolean hasNext() {
			return (cursor < accountNumber.size());
		}

		@Override
		public Digit next() {
			return accountNumber.get(cursor++);
		}

	}
}
