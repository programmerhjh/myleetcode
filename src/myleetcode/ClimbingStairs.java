package myleetcode;

/**
 * 爬楼梯
 * 斐波那契数列问题
 * @author acer
 *
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
    	if (n <= 3) {
			return n;
		}
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i < f.length; i++) {
        	f[i] = f[i-1] + f[i-2];
		}
        return f[n];
    }
}
