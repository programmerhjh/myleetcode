package myleetcode;

import java.math.BigInteger;

/**
 * 字符串转整数 
 * @author acer
 *
 */
public class StringToIntegerAtoi {

	public static int myAtoi(String str) {
		str = str.trim();
		String[] split = str.split("([a-z][A-Z]{0,})|([A-Z][a-z]{0,})|\\ |\\.");
		if (split.length != 0 && split[0] != null) {
			String string = split[0].trim();
			if (string.length() > 2 && string.lastIndexOf("-") != 0 && string.lastIndexOf("-") != -1) {
				string = string.substring(0, string.indexOf("-", 1));
			} else if (string.length() > 2 && string.lastIndexOf("+") != 0 && string.lastIndexOf("+") != -1) {
				string = string.substring(0, string.indexOf("+", 1));
			}
			if (string.matches("(\\-{0,1}[0-9]{1,})|(\\+{0,1}[0-9]{1,})")) {
				BigInteger bigInteger = new BigInteger(string);
				if (bigInteger.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) == -1) {
					return Integer.MIN_VALUE;
				} else if (bigInteger.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) == 1) {
					return Integer.MAX_VALUE;
				}
				if (str.indexOf(string) == 0) {
					return Integer.parseInt(string);
				}
			} else {
				return 0;
			}
		}
		return 0;
    }
}
