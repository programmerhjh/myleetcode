package myleetcode;


/**
 * 搜索旋转排序数组
 * 二分法
 * @author HJH
 *
 */
public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right)/2;
            if (nums[mid] == target) return mid;
            else if (nums[left] == target) return left;
            else if (nums[right] == target) return right;
            if (nums[mid] < nums[right]){
                if (nums[mid] < target && target < nums[right]) left = mid + 1;
                else right = mid - 1;
            }else{
                if (nums[left] < target && target < nums[mid]) right = mid -1;
                else left = mid + 1;
            }
        }
        return -1;
	}
	
}
