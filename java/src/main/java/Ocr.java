import java.util.List;
import java.util.ArrayList;

public class Ocr {

	private static final char[][][] NUMERALS = new char[][][] {
			{ " _  ".toCharArray(), "| | ".toCharArray(), "|_| ".toCharArray(), "    ".toCharArray() },
			{ "    ".toCharArray(), "  | ".toCharArray(), "  | ".toCharArray(), "    ".toCharArray() },
			{ " _  ".toCharArray(), " _| ".toCharArray(), "|_  ".toCharArray(), "    ".toCharArray() },
			{ " _  ".toCharArray(), " _| ".toCharArray(), " _| ".toCharArray(), "    ".toCharArray() },
			{ "    ".toCharArray(), "|_| ".toCharArray(), "  | ".toCharArray(), "    ".toCharArray() },
			{ " _  ".toCharArray(), "|_  ".toCharArray(), " _| ".toCharArray(), "    ".toCharArray() },
			{ " _  ".toCharArray(), "|_  ".toCharArray(), "|_| ".toCharArray(), "    ".toCharArray() },
			{ " _  ".toCharArray(), "  | ".toCharArray(), "  | ".toCharArray(), "    ".toCharArray() },
			{ " _  ".toCharArray(), "|_| ".toCharArray(), "|_| ".toCharArray(), "    ".toCharArray() },
			{ " _  ".toCharArray(), "|_| ".toCharArray(), " _| ".toCharArray(), "    ".toCharArray() } };

	public static List<String> parse(String... lines) {
		final List<String> result = new ArrayList<String>();
		for (int i = 0; i < lines.length; i += 4) {
			StringBuilder sb = new StringBuilder();
			String marker = "    ";
			for (int pos = 0; pos < 9; ++pos) {
				sb.append("?");
				for (int numeral = 0; numeral <= 9; ++numeral) {
					boolean ok = true;
					for (int row = 0; row < 4; ++row) {
						for (int col = 0; col < 4; ++col) {
							if (NUMERALS[numeral][row][col] != lines[i + row].charAt(4 * pos + col)) {
								ok = false;
							}
						}
					}
					if (ok) {
						int lastPosition = sb.lastIndexOf("?");
						sb.replace(lastPosition, lastPosition + 1, String.valueOf(numeral));
						break;
					}
				}
			}
			if(sb.indexOf("?") > -1) {
				marker = " ILL";				
			}
			sb.append(marker);
			result.add(sb.toString());
		}
		return result;
	}
}
