package myleetcode;

import java.util.*;

/**
 * <p>
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 *
 * 注意：本题相对原题稍作修改
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * </p>
 *
 * @author hongjh
 * @since 2020/10/10
 */
public class GroupAnagramsLCCI {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>(16);
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newString = new String(chars);
            if (!map.containsKey(newString)) {
                ArrayList<String> list = new ArrayList<String>() {{
                    add(str);
                }};
                map.put(newString, list);
            } else {
                map.get(newString).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

}
