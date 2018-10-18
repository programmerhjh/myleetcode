package myleetcode;

/**
 * 删除排序数组中的重复项
 * @author acer
 *
 */
public class RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] nums) {
        int temp = 0;
        if (nums.length == 0) {
			return 0;
		}
        for (int i = 0; i < nums.length;) {
        	if (i == 0) {
				temp = nums[i++];
			} else {
				if (temp == nums[i]) {
					if (i >= nums.length - 1) {
						return nums.length - (nums.length - i);
					}
					int j = i + 1;
					while (nums[j] == temp) {
						if (j >= nums.length - 1) {
							System.arraycopy(nums, j, nums, i, nums.length-j);
							return nums.length - (j - i + 1);
						}
						j++;
					}
					System.arraycopy(nums, j, nums, i, nums.length-j);
				} else {
					if (i >= nums.length || temp > nums[i]) {
						return i;
					}
					temp = nums[i];
					i++;
				}
			}
		}
        return nums.length;
	}
	
}
