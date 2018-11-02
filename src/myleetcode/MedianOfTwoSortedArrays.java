package myleetcode;

import java.util.Arrays;

/**
 * 两个排序数组的中位数
 * @author acer
 *
 */
public class MedianOfTwoSortedArrays {
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double result = 0;
		int[] resultArray = new int[nums1.length + nums2.length];
		int[] totalNums = new int[nums1.length + nums2.length];
		for (int i = 0; i < nums1.length; i++) {
			totalNums[i] = nums1[i];
		}
		int temp = nums1.length;
		for (int i = 0; i < nums2.length; i++, temp++) {
			totalNums[temp] = nums2[i];
		}
		mergesort(totalNums, 0, totalNums.length-1, resultArray);
		if (totalNums.length % 2 == 0) {
			result = (totalNums[totalNums.length/2] + totalNums[totalNums.length/2-1])/2.0;
		} else if (totalNums.length == 1) {
			result = totalNums[0];
		} else {
			result = totalNums[totalNums.length/2];
		}
		return result;
    }
	
	static void mergearray(int a[], int first, int mid, int last, int b[])
	{
	    int i = first, j = mid + 1;
	    int m = mid, n = last;
	    int k = 0;

	    while (i <= m && j <= n)
	    {
	        if (a[i] <= a[j]) {
	            b[k++] = a[i++];
	    	} else {
	        	b[k++] = a[j++];
	        }
	    }

	    while (i <= m) {
	    	b[k++] = a[i++];
	    }

	    while (j <= n) {
	    	b[k++] = a[j++];
	    }

	    for (i = 0; i < k; i++) {
	    	a[first + i] = b[i];
	    }
	}
	
	static void mergesort(int a[], int first, int last, int b[])
	{
	    if (first < last)
	    {
	        int mid = (first + last) / 2;
	        mergesort(a, first, mid, b);    //左边有序
            mergesort(a, mid + 1, last, b); //右边有序
	        mergearray(a, first, mid, last, b); // 再将二个有序数列合并
	    }
	}
	
}
