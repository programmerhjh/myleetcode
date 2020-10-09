package myleetcode;

/**
 * <p>
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * 说明:
 *
 * A.length == n + m
 * </p>
 *
 * @author hongjh
 * @since 2020/10/9
 */
public class SortedMergeLCCI {

    public void merge(int[] A, int m, int[] B, int n) {
        int ia = m - 1, ib = n - 1, curr = A.length - 1;
        while (ia >= 0 || ib >= 0) {
            if (ia == -1) {
                A[curr--] = B[ib--];
            } else if (ib == -1) {
                A[curr--] = A[ia--];
            } else if (A[ia] > B[ib]) {
                A[curr--] = A[ia--];
            } else {
                A[curr--] = B[ib--];
            }
        }
    }

}
