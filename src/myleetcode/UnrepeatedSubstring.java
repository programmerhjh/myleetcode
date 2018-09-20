package myleetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符子串
 * 
 * @author acer
 *
 */
public class UnrepeatedSubstring {
	
	public static void main(String[] args) {
		String s = "bbbbb"; // 输入项
		Map<String, String> strMap = new HashMap<String, String>();
		int result = 0;
		int tmp2 = 0;
		for (int j = 0; j < s.length(); j++) {
			for (int i = j; i < s.length(); i++) {
				if (strMap.isEmpty()) {
					strMap.put(s.substring(i, i+1), s.substring(i, i+1));
					tmp2++;
					continue;
				} else if (strMap.containsKey(s.substring(i, i+1))) {
					break;
				} else {
					tmp2++;
					strMap.put(s.substring(i, i+1), s.substring(i, i+1));
				}
			}
			if (result < tmp2) {
				result = tmp2;
			}
			strMap.clear();
			tmp2 = 0;
		}
		System.out.println(result);
	}
}
