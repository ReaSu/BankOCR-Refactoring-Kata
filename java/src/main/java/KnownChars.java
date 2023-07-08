import java.util.Arrays;
import java.util.List;

class KnownChars {
	public static int correspondsTo(InputDigit input, List<String> image, int number) {
		for (int i = 0; i < 4; i++) {
			if (!image.get(i).equals(input.get(i))) {
				return -1;
			}
		}
		return number;
	}

	public int correspondsTo(InputDigit inputDigit) {
		// TODO Auto-generated method stub
		return 0;
	}
}

class Zero extends KnownChars {
	List<String> image = Arrays.asList(
			" _  ", 
			"| | ", 
			"|_| ", 
			"    ");
	int digit = 0;
	
	public int correspondsTo(InputDigit input) {
		return KnownChars.correspondsTo(input, image, digit);
	}
}

class One extends KnownChars {
	List<String> image = Arrays.asList(
			"    ",
			"  | ",
			"  | ",
			"    ");
	int digit = 1;
	
	public int correspondsTo(InputDigit input) {
		return KnownChars.correspondsTo(input, image, digit);
	}
}

class Two extends KnownChars {
	List<String> image = Arrays.asList(
			" _  ", 
			" _| ", 
			"|_  ", 
			"    ");
	int digit = 2;
	
	public int correspondsTo(InputDigit input) {
		return KnownChars.correspondsTo(input, image, digit);
	}
}

class Three extends KnownChars {
	List<String> image = Arrays.asList(
			" _  ", 
			" _| ", 
			" _| ", 
			"    ");
	int digit = 3;
	
	public int correspondsTo(InputDigit input) {
		return KnownChars.correspondsTo(input, image, digit);
	}
}

class Four extends KnownChars {
	List<String> image = Arrays.asList(
			"    ", 
			"|_| ", 
			"  | ", 
			"    ");
	int digit = 4;
	
	public int correspondsTo(InputDigit input) {
		return KnownChars.correspondsTo(input, image, digit);
	}
}

class Five extends KnownChars {
	List<String> image = Arrays.asList(
			" _  ", 
			"|_  ", 
			" _| ", 
			"    ");
	int digit = 5;
	
	public int correspondsTo(InputDigit input) {
		return KnownChars.correspondsTo(input, image, digit);
	}
}

class Six extends KnownChars {
	List<String> image = Arrays.asList(
			" _  ", 
			"|_  ", 
			"|_| ", 
			"    ");
	int digit = 6;
	
	public int correspondsTo(InputDigit input) {
		return KnownChars.correspondsTo(input, image, digit);
	}
}

class Seven extends KnownChars {
	List<String> image = Arrays.asList(
			" _  ",
			"  | ",
			"  | ",
			"    ");
	int digit = 7;
	
	public int correspondsTo(InputDigit input) {
		return KnownChars.correspondsTo(input, image, digit);
	}
}

class Eight extends KnownChars {
	List<String> image = Arrays.asList(
			" _  ", 
			"|_| ", 
			"|_| ", 
			"    ");
	int digit = 8;
	
	public int correspondsTo(InputDigit input) {
		return KnownChars.correspondsTo(input, image, digit);
	}
}

class Nine extends KnownChars {
	List<String> image = Arrays.asList(
			" _  ", 
			"|_| ", 
			" _| ", 
			"    ");
	int digit = 9;
	
	public int correspondsTo(InputDigit input) {
		return KnownChars.correspondsTo(input, image, digit);
	}
}
