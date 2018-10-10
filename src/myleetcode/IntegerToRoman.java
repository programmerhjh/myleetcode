package myleetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 整数转罗马数字
 * @author acer
 *
 */
public class IntegerToRoman {

	private static HashMap<Integer, String> map = new HashMap<>();
	private static String[] strings = new String[] {"I","V","X","L","C","D","M"};
	private static LinkedList<Integer> list = new LinkedList<>();
	
	public static String intToRoman(int num) {
		String result = "";
		int start = 1;
		for (int i = 1; i <= 7; i++) {
			map.put(start, strings[i-1]);
			list.add(start);
			if (i % 2 != 0) {
				start = start * 5;
			} else {
				start = start * 2;
			}
		}
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		
		while (!list.isEmpty()) {
			String pre = "";
			for (int i = 0; i < list.size();) {
				if (num / list.get(i) == 0) {
					pre = String.valueOf(map.get(list.removeFirst()));
					continue;
				} else {
					Integer integer = list.get(i);
					int times = 0;
					int temp = 0;
					if (list.size() % 2 == 0) {
						temp = list.get(i + 1);
						times = num / temp;
					} else {
						temp = list.getFirst();
						times = num / temp;
					}
					if (times == 9) {
						result += map.get(temp) + pre;
					} else if (times == 5) {
						result += map.get(temp * times);
					} else if (times == 4) {
						result += map.get(temp) + map.get(temp*5); 
					} else if (times == 10) {
						result += map.get(temp*10);
					} else {
						if (times <= 5) {
							for (int j = 0; j < times; j++) {
								result += map.get(integer);
							}
						} else {
							result += map.get(integer);
							for (int j = 0; j < times % 5; j++) {
								result += map.get(list.get(i + 1));
							}
						}
						pre = map.get(integer);
					}
					num = num % temp;
				}
				pre = String.valueOf(map.get(list.removeFirst()));
			}
		}
		return result;
    }
}
