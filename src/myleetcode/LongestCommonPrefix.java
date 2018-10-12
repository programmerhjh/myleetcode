package myleetcode;

public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] {}));
	}
	
	public static String longestCommonPrefix(String[] strs) {	
		if (strs.length == 0) {
			return "";
		}
		String result = strs[0];
		for (int i = 1; i < strs.length; i++) {
			String string = strs[i];
			boolean isChange = false;
			int times = 0;
			if (string.length() >= result.length()) {
				times = result.length();
			} else {
				times = string.length();
			}
			for (int j = times; j >= 1; j--) {
				if (result.substring(0, j).equals(string.substring(0, j))) {
					result = result.substring(0, j);
					isChange = true;
					break;
				}
			}
			if (!isChange) {
				if (!result.equals(string)) {
					return "";
				}
			}
		}
		return result;
    }
	
}
