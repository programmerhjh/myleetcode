package myleetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 三数之和
 * @author acer
 *
 */
public class ThreeNumbersSum {
	
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length == 0 || nums.length == 1 || nums.length == 2) {
			return result;
		}
		List<Integer> positiveNumbers = new ArrayList<>();
		List<Integer> negativeNumbers = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int j = nums[i];
			if (j >= 0) {
				positiveNumbers.add(j);
			} else {
				negativeNumbers.add(j);
			}
		}
		Collections.sort(positiveNumbers);
		Collections.sort(negativeNumbers);
		HashSet<Integer> positiveSet = new HashSet<>(positiveNumbers);
		HashSet<Integer> negativeSet = new HashSet<>(negativeNumbers);
		int a = 0,b = 1;
		int tempB = 0, tempA = 0;
		int zeroLastIndex = -1;
		if (positiveNumbers.size() == 0) {
			return result;
		} else if ((zeroLastIndex = positiveNumbers.lastIndexOf(0)) >= 2) {
			result.add(Arrays.asList(0, 0, 0));
			b = zeroLastIndex;
			if (b >= positiveNumbers.size() - 1) {
				a ++;
				b = a + 1;
			} else {
				b ++;
			}
		}
		if (negativeNumbers.size() == 0) {
			return result;
		}
		tempA = positiveNumbers.get(a);
		if (positiveNumbers.size() >= 2) {
			while (a != positiveNumbers.size() - 1 || b != positiveNumbers.size()) {
				int numA = positiveNumbers.get(a);
				int numB = positiveNumbers.get(b);
				if (b == a + 1) {
					tempB = numB;
				}
				if (tempB == numB && b != a + 1) {
					if (b >= positiveNumbers.size() - 1) {
						while (positiveNumbers.get(++a) == tempA) {
							if (a > positiveNumbers.size() - 2) {
								break;
							}
						}
						if (a > positiveNumbers.size() - 2) {
							b = a + 1;
							break;
						}
						tempA = positiveNumbers.get(a);
						b = a + 1;
						tempB = positiveNumbers.get(b);
					} else {
						b ++;
					}
					continue;
				}
				tempB = numB;
				int quotients = - (numA + numB);
				if (negativeSet.contains(quotients)) {
					result.add(Arrays.asList(numA, numB, quotients));
				}
				if (b >= positiveNumbers.size() - 1) {
					while (positiveNumbers.get(++a) == tempA) {
						if (a > positiveNumbers.size() - 2) {
							break;
						}
					}
					if (a > positiveNumbers.size() - 2) {
						b = a + 1;
						break;
					}
					tempA = positiveNumbers.get(a);
					b = a + 1;
					tempB = positiveNumbers.get(b);
				} else {
					b ++;
				}
			}
		}
		a = 0;
		b = 1;
		tempA = negativeNumbers.get(a);
		if (negativeNumbers.size() >= 2) {
			while (a != negativeNumbers.size() - 1 || b != negativeNumbers.size()) {
				int numA = negativeNumbers.get(a);
				int numB = negativeNumbers.get(b);
				if (b == a + 1) {
					tempB = numB;
				}
				if (tempB == numB && b != a + 1) {
					if (b >= negativeNumbers.size() - 1) {
						while (negativeNumbers.get(++a) == tempA) {
							if (a > negativeNumbers.size() - 2) {
								break;
							}
						}
						if (a > negativeNumbers.size() - 2) {
							b = a + 1;
							break;
						}
						tempA = negativeNumbers.get(a);
						b = a + 1;
						tempB = negativeNumbers.get(b);
					} else {
						b ++;
					}
					continue;
				} 
				tempB = numB;
				int quotients = - (numA + numB);
				if (positiveSet.contains(quotients)) {
					result.add(Arrays.asList(numA, numB, quotients));
				}
				if (b >= negativeNumbers.size() - 1) {
					while (negativeNumbers.get(++a) == tempA) {
						if (a > negativeNumbers.size() - 2) {
							break;
						}
					}
					if (a > negativeNumbers.size() - 2) {
						b = a + 1;
						break;
					}
					tempA = negativeNumbers.get(a);
					b = a + 1;
					tempB = negativeNumbers.get(b);
				} else {
					b ++;
				}
			}
		}
		return result;
	}
}
