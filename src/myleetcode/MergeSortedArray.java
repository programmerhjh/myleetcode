package myleetcode;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * @author acer
 *
 */
public class MergeSortedArray {
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if (nums2.length == 0 || nums1.length == 0) {
			return;
		}
		if (m == 0) {
			System.arraycopy(nums2, 0, nums1, 0, nums2.length);
			return;
		}
		int arrIndex = 0, i = 0, j = 0, temp = nums1[i], temp2 = nums2[j];
		int[] copyOf = Arrays.copyOf(nums1, nums1.length);
		while(true) {
			if (i >= m - 1) {
				for (int k = j; k < n; k++,i++) {
					if (temp < nums2[k]) {
						nums1[arrIndex++] = temp;
						temp = nums2[k];
						continue;
					}
					nums1[arrIndex++] = nums2[k];
				}
				nums1[arrIndex] = temp > nums1[arrIndex - 1] ? temp : nums2[nums2.length-1];
				break;
			}
			if (j >= n - 1) {
				for (int k = i; k < m; k++) {
					if (temp2 < copyOf[k]) {
						nums1[arrIndex++] = temp2;
						temp2 = copyOf[k];
						continue;
					}
					nums1[arrIndex++] = copyOf[k];
				}
				nums1[arrIndex] = temp2 > nums1[arrIndex - 1] ? temp2 : copyOf[m - 1];
				break;
			}
			if (temp <= temp2) {
				nums1[arrIndex++] = temp;
				temp = copyOf[++i];
			} else {
				nums1[arrIndex++] = temp2;
				temp2 = nums2[++j];
			}
		}
    }
}
