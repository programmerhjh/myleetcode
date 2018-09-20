package myleetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Z字形变换
 * @author acer
 *
 */
public class ZigZagConversion {
	
	public static void main(String[] args) {
		System.out.println(convert("A", 2));
	}
	
	public static String convert(String s, int numRows) {
        
		if (numRows == 1) {
			return s;
		}
		
		Map<Integer, String> map = new HashMap<>();
		String resultStr = "";
		
		int row = 0;
		boolean flag = true;
		// true表示列数不变，false表示列数需要变
		boolean columnFlag = true;
		for (int i = 0; i < s.length(); i++) {
			
			String str = String.valueOf(s.charAt(i));
			
			if (i == 0) {
				map.put(row, str);
				continue;
			}
			
			if (row == numRows-1) {
				flag = false;
				columnFlag = false;
			} else if (row == 0) {
				flag = true;
				columnFlag = true;
			}
			
			if (flag && columnFlag) {
				row ++;
			} else if(!flag && !columnFlag) {
				row --;
			}
		
			if (map.containsKey(row)) {
				String updateStr = map.get(row) + str;
				map.put(row, updateStr);
			} else {
				map.put(row, str);
			}
		}
		
		for (int i = 0; i < map.size(); i++) {
			resultStr += map.get(i);
		}
		
		return resultStr;
    }
}
