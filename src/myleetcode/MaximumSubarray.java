package myleetcode;

/**
 * 最大子序和
 * @author acer
 *
 */
public class MaximumSubarray {

	public static int maxSubArray(int[] nums) {
		return sort(nums, 0);
    }
	
	public static int sort(int[] nums, int start) {
		if (start >= nums.length-1) {
			return nums[start]; 
		}
		int max, sum = nums[start], temp = nums[start], i = start + 1;
		for (;i < nums.length; i++) {
			sum += nums[i];
			temp = temp > sum ? temp : sum;
		}
		return temp > (max = sort(nums, ++start)) ? temp : max;
	}
	
}
