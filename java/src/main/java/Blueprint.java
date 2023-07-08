import java.util.Arrays;
import java.util.List;

class Blueprint {
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

class Zero extends Blueprint {
	List<String> image = Arrays.asList(
			" _  ", 
			"| | ", 
			"|_| ", 
			"    ");
	int digit = 0;
	
	public int correspondsTo(InputDigit input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}

class One extends Blueprint {
	List<String> image = Arrays.asList(
			"    ",
			"  | ",
			"  | ",
			"    ");
	int digit = 1;
	
	public int correspondsTo(InputDigit input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}

class Two extends Blueprint {
	List<String> image = Arrays.asList(
			" _  ", 
			" _| ", 
			"|_  ", 
			"    ");
	int digit = 2;
	
	public int correspondsTo(InputDigit input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}

class Three extends Blueprint {
	List<String> image = Arrays.asList(
			" _  ", 
			" _| ", 
			" _| ", 
			"    ");
	int digit = 3;
	
	public int correspondsTo(InputDigit input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}

class Four extends Blueprint {
	List<String> image = Arrays.asList(
			"    ", 
			"|_| ", 
			"  | ", 
			"    ");
	int digit = 4;
	
	public int correspondsTo(InputDigit input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}

class Five extends Blueprint {
	List<String> image = Arrays.asList(
			" _  ", 
			"|_  ", 
			" _| ", 
			"    ");
	int digit = 5;
	
	public int correspondsTo(InputDigit input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}

class Six extends Blueprint {
	List<String> image = Arrays.asList(
			" _  ", 
			"|_  ", 
			"|_| ", 
			"    ");
	int digit = 6;
	
	public int correspondsTo(InputDigit input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}

class Seven extends Blueprint {
	List<String> image = Arrays.asList(
			" _  ",
			"  | ",
			"  | ",
			"    ");
	int digit = 7;
	
	public int correspondsTo(InputDigit input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}

class Eight extends Blueprint {
	List<String> image = Arrays.asList(
			" _  ", 
			"|_| ", 
			"|_| ", 
			"    ");
	int digit = 8;
	
	public int correspondsTo(InputDigit input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}

class Nine extends Blueprint {
	List<String> image = Arrays.asList(
			" _  ", 
			"|_| ", 
			" _| ", 
			"    ");
	int digit = 9;
	
	public int correspondsTo(InputDigit input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}
