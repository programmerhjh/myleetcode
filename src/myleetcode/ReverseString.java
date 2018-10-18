package myleetcode;

/**
 * 反转字符串
 * @author acer
 *
 */
public class ReverseString {

	public static String reverseString(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length / 2; i++) {
        	int r = cs.length - 1 - i;
			char lc = cs[i];
			char rc = cs[r];
			cs[i] = rc;
			cs[r] = lc;
		}
        return new String(cs);
    }
	
}
