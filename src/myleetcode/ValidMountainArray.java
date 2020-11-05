package myleetcode;

/**
 * <p>
 * 941. 有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * 示例 1：
 *
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 *
 * 输入：[0,3,2,1]
 * 输出：true
 *
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * </p>
 *
 * @author hongjh
 * @since 2020/11/5
 */
public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        if (A.length == 0) {
            return false;
        }
        boolean up = false, down = false;
        for (int i = 1; i < A.length; i++) {
            int pre = A[i-1], cur = A[i];
            if (pre < cur) {
                if (down) {
                    return false;
                }
                up = true;
            } else if (pre > cur) {
                if (!up) {
                    return false;
                }
                down = true;
            } else {
                return false;
            }
        }
        return up && down;
    }

}
