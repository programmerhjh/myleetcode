/**
 * 
 */
package myleetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * @author HJH
 *
 * @date 2018年12月11日
 */
public class Permutations {

	public static List<List<Integer>> permute(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			temp.add(nums[i]);
		}
		result.add(new ArrayList<>(temp));
		deal(result, temp, 0);
		return result;
    }
	
	/**
	 * 每一次都是对当前start所规定的开始下标到后面的数进行排列
	 * @param result
	 * @param temp
	 * @param start
	 */
	public static void deal(List<List<Integer>> result, List<Integer> temp, int start) {
		if (start == temp.size() - 1) {
			return;
		}
		for (int i = start; i <= temp.size() - 1; i++) {
			int a = temp.get(i);
			temp.set(i, temp.get(start));
			temp.set(start, a);
			deal(result, temp, start + 1);
			// 去重，只把起始位置与后面位置的交换的数组添加
			if (i > start) {
				result.add(new ArrayList<>(temp));
			}
			a = temp.get(i);
			temp.set(i, temp.get(start));
			temp.set(start, a);
        }
	}
	
}
