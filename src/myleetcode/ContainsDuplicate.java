package myleetcode;

import java.util.HashMap;

/**
 * 存在重复元素
 * @author acer
 *
 */
public class ContainsDuplicate {
	
	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[] {1,2,3}));
	}

	public static boolean containsDuplicate(int[] nums) {
		HashMap<Integer, String> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int j = nums[i];
			if (map.containsKey(j)) {
				return true;
			}
			map.put(j, null);
		}
		return false;
	}
	
}
