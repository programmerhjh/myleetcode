package myleetcode;

/**
 * 盛最多水的容器
 * @author acer
 *
 */
public class ContainerWithMostWater {

	public static int maxArea(int[] height) {
		int start = 0, end = height.length - 1;
		int result = (end - start) * Math.min(height[start], height[end]);
		while(start != end) {
			int area = (end - start) * Math.min(height[start], height[end]);
			if (height[start] <= height[end]) {
				start ++;
			} else {
				end --;
			}
			result = result < area ? area : result;
		}
		return result;
    }
	
}
