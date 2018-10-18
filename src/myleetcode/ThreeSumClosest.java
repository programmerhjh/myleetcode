package myleetcode;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * @author acer
 *
 */
public class ThreeSumClosest {

	public static int threeSumClosest(int[] nums, int target) {
		if (nums.length < 3) {
			return 0;
		}
		Arrays.sort(nums);
		int a = 0, b = 1, c = 2;
		boolean flag = true;
		int temp = Integer.MAX_VALUE;
		while (a < nums.length - 2) {
			int rs = nums[a] + nums[b] + nums[c];
			if (rs > target) {
				int x = rs - target;
				if (x == 0) {
					return target;
				}
				if (temp > x) {
					temp = x;
					flag = true;
				} 
			} else {
				int x = target - rs;
				if (x == 0) {
					return target;
				}
				if (temp > x) {
					temp = x;
					flag = false;
				} 
			}
			c ++;
			if (c >= nums.length) {
				b ++;
				c = b + 1;
				if (b >= nums.length - 1) {
					a ++;
					b = a + 1;
					c = b + 1;
				}
			}
		}
		if (flag) {
			return target + temp;
		}
		return target - temp;
    }
	
}
