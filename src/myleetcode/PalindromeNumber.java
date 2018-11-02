package myleetcode;

/**
 * 回文数
 * @author acer
 *
 */
public class PalindromeNumber {
	
	public static boolean isPalindrome(int x) {
		boolean result = true;
		if (x < 0) {
			result = false;
			return result;
		}
		int times = 1;
		int x1 = x;
		while(x1 / 10 != 0) {
			x1 = x1 / 10;
			times ++;
		}
		if (times <= 1) {
			return result;
		} else if (times == 2 && x % 11 == 0) {
			return result;
		}
		boolean flag = true;
		int i = 1;
		int mid = times / 2;
		if (times % 2 == 0) {
			while (flag) {
				int left = (x / (int)Math.pow(10, mid+i-1)) % 10;
				int powRight = (int)Math.pow(10, mid-i+1);
				int right = x % powRight;
				if (right >= powRight/10) {
					right = right / (powRight / 10);
				} else {
					right = 0;
				}
				if (left != right) {
					result = false;
					break;
				}
				if (i + mid == times - 1) {
					flag = false;
				}
				i ++;
			}
		} else {
			while (flag) {
				int left = (x / (int)Math.pow(10, mid+i)) % 10;
				int powRight = (int)Math.pow(10, mid-i+1);
				int right = x % powRight;
				if (right >= powRight / 10) {
					right = right / (powRight / 10);
				} else {
					right = 0;
				}
				if (left != right) {
					result = false;
					break;
				}
				if (i + mid == times - 1) {
					flag = false;
				}
				i ++;
			}
		}
		return result;
    }
	
}
