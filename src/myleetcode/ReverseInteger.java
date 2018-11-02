package myleetcode;

/**
 * 反转整数
 * @author acer
 *
 */
public class ReverseInteger {

	private static StringBuffer stringBuffer = new StringBuffer();
	
	public static int reverse(int x) {
		Long result = 0L;
		if (x >= 0) {
			String str = stringBuffer.append(String.valueOf(x)).reverse().toString();
			result = Long.parseLong(str);
		} else {
			String valueOf = String.valueOf(x);
			String substring = valueOf.substring(1, valueOf.length());
			String str = stringBuffer.append(substring).reverse().insert(0, "-").toString();
			result = Long.parseLong(str);
		}
		stringBuffer.delete(0, stringBuffer.length());
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return 0;
		}
		return result.intValue();
    }
	
}
