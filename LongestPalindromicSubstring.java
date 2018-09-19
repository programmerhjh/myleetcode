package myleetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * @author acer
 *
 */
public class LongestPalindromicSubstring {

	private ArrayList<String> alphabetArray = new ArrayList<>();
	private HashMap<String,Integer> stringAlphabetMap = new HashMap<>();
	private String resultString = "";
	
	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbbd"));
	}
	
	public String longestPalindrome(String s) {
		StringBuffer sBuffer = new StringBuffer();
		if (s.equals(new StringBuffer(s).reverse().toString())) {
			resultString = s;
			return resultString;
		}
		String[] split = s.split("");
		for (int i=0;i < split.length;i++) {
			if (!stringAlphabetMap.containsKey(split[i]) && !alphabetArray.contains(split[i])) {
				stringAlphabetMap.put(split[i], i);
				alphabetArray.add(split[i]);
			}
		}
		while(!stringAlphabetMap.isEmpty()) {
			for (int i = 0; alphabetArray.size()!=0;) {
				String tempString = "";
				if (tempString.length() == 0) {
					tempString = alphabetArray.get(i);
				}
				String string = alphabetArray.get(i);
				Integer index = stringAlphabetMap.get(string);
				int x = index;
				int lastIndex = 0;
				for (x = index; s.indexOf(string, x+1) != -1; x=s.indexOf(string, x+1)) {
					lastIndex = s.length();
					for (int j=x;s.lastIndexOf(string,lastIndex-1) != j;lastIndex=s.lastIndexOf(string, lastIndex-1)) {
						if (lastIndex - x <= tempString.length()) {
							break;
						}
						String curString = s.substring(x, s.lastIndexOf(string,lastIndex-1)+1);
						sBuffer.append(curString);
						if (sBuffer.toString().equals(sBuffer.reverse().toString()) && tempString.length() < sBuffer.length()) {
							tempString = curString;
							sBuffer.delete(0, sBuffer.length());
							break;
						} else {
							sBuffer.delete(0, sBuffer.length());
						}
					}
					if (tempString.length() > s.length()-x) {
						break;
					}
				}
				if (resultString.length() < tempString.length()) {
					resultString = tempString;
				}
				
				alphabetArray.remove(i);
				stringAlphabetMap.remove(string);
			}
		}
		return resultString;
	}
}
