package myleetcode;

/**
 * 只出现一次的数字
 * @author acer
 *
 */
public class SingleNumber {
	
	public int singleNumber(int[] nums) {
        //两个相同的数异或结果为0，一个数跟0异或是这个数本身
        int test = 0;
        for ( int i = nums.length -1 ; i >= 0; --i) {
            test ^= nums[i];
        }
        return test;
    }
	
//    public int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//        int temp = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//        	if (temp != nums[i] && i % 2 == 1) {
//				return temp;
//			}
//        	temp = nums[i];
//		}
//        return temp;
//    }
}
