import java.util.Arrays;
import java.util.List;

interface Blueprint {

	public static int correspondsTo(List<String> input, List<String> image, int number) {
		for (int i = 0; i < 4; i++) {
			if (!image.get(i).equals(input.get(i))) {
				return -1;
			}
		}
		return number;
	}

	int correspondsTo(List<String> block);

}

class NumberZero implements Blueprint {
	List<String> image = Arrays.asList(
			" _  ", 
			"| | ", 
			"|_| ", 
			"    ");
	int digit = 0;
	
	public int correspondsTo(List<String> input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}

class NumberOne implements Blueprint {
	List<String> image = Arrays.asList(
			"    ",
			"  | ",
			"  | ",
			"    ");
	int digit = 1;
	
	public int correspondsTo(List<String> input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}

class NumberTwo implements Blueprint {
	List<String> image = Arrays.asList(
			" _  ", 
			" _| ", 
			"|_  ", 
			"    ");
	int digit = 2;
	
	public int correspondsTo(List<String> input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}

class NumberThree implements Blueprint {
	List<String> image = Arrays.asList(
			" _  ", 
			" _| ", 
			" _| ", 
			"    ");
	int digit = 3;
	
	public int correspondsTo(List<String> input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}

class NumberFour implements Blueprint {
	List<String> image = Arrays.asList(
			"    ", 
			"|_| ", 
			"  | ", 
			"    ");
	int digit = 4;
	
	public int correspondsTo(List<String> input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}

class NumberFive implements Blueprint {
	List<String> image = Arrays.asList(
			" _  ", 
			"|_  ", 
			" _| ", 
			"    ");
	int digit = 5;
	
	public int correspondsTo(List<String> input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}

class NumberSix implements Blueprint {
	List<String> image = Arrays.asList(
			" _  ", 
			"|_  ", 
			"|_| ", 
			"    ");
	int digit = 6;
	
	public int correspondsTo(List<String> input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}

class NumberSeven implements Blueprint {
	List<String> image = Arrays.asList(
			" _  ",
			"  | ",
			"  | ",
			"    ");
	int digit = 7;
	
	public int correspondsTo(List<String> input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}

class NumberEight implements Blueprint {
	List<String> image = Arrays.asList(
			" _  ", 
			"|_| ", 
			"|_| ", 
			"    ");
	int digit = 8;
	
	public int correspondsTo(List<String> input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}

class NumberNine implements Blueprint {
	List<String> image = Arrays.asList(
			" _  ", 
			"|_| ", 
			" _| ", 
			"    ");
	int digit = 9;
	
	public int correspondsTo(List<String> input) {
		return Blueprint.correspondsTo(input, image, digit);
	}
}
