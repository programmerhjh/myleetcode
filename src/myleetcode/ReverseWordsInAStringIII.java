package myleetcode;

/**
 * 反转字符串中的单词 III
 * @author acer
 *
 */
public class ReverseWordsInAStringIII {

	public static String reverseWords(String s) {
		String result = "";
        if (s.length() == 0) {
        	return result;
		}
		String[] strings = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
        	String string = strings[i];
        	stringBuilder.delete(0, stringBuilder.length());
        	stringBuilder.append(string).reverse();
			if (i >= strings.length - 1) {
				result += stringBuilder.toString();
			} else {
				result += stringBuilder.toString() + " ";
			}
        }
        return result;
    }
	
}
