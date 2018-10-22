package myleetcode;

/**
 * 有效的括号
 * @author acer
 *
 */
public class ValidParentheses {

	public static boolean isValid(String s) {
		s = s.trim();
		if (s.length() == 0) {
			return true;
		}
		if (s.length() % 2 == 1) {
			return false;
		}
		StringBuffer buffer = new StringBuffer(s);
		while (buffer.length() != 0) {
			int tempLen = buffer.length();
			for (int i = 0; i < buffer.length()-1; ) {
				if (
						((int) buffer.charAt(i) == 40 && (int) buffer.charAt(i+1) == 41) 
						|| ((int) buffer.charAt(i) == 91 && (int) buffer.charAt(i+1) == 93) 
						|| ((int) buffer.charAt(i) == 123 && (int) buffer.charAt(i+1) == 125)	
				   ) {
					buffer.delete(i, i+2);
					break;
				} else {
					i++;
				}
			}
			if (buffer.length() == tempLen && tempLen != 0) {
				return false;
			}
		}
		return true;
    }
	
}
