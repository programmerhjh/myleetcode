package myleetcode;

/**
 * 求众数 (摩尔投票法)
 * 
 * @author acer
 *
 */
public class MajorityElement {

	public static int majorityElement(int[] nums) {
		if(nums.length == 1){
            return nums[0];
        }
		int count = 1, maj = nums[0];
		for (int i = 1; i < nums.length; i++) { 
			if (maj == nums[i]) 
				count++; 
			else { 
				count--; 
				if (count == 0) { 
					maj = nums[i]; 
					count = 1; 
				} 
			}
		}
		return maj;
    }
	
}
