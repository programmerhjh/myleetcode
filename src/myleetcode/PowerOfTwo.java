package myleetcode;

/**
 * 2的幂
 * @author acer
 *
 */
public class PowerOfTwo {
	
	public static boolean isPowerOfTwo(int n) {
        if ((n & n-1) == 0) {
			return true;
		} else {
			return false;
		}
    }
	
}
