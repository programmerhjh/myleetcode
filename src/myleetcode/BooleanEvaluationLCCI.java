package myleetcode;

/**
 * <p>
 * 08.14. 布尔运算
 * 给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。
 * 实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。
 *
 * 示例 1:
 *
 * 输入: s = "1^0|0|1", result = 0
 *
 * 输出: 2
 * 解释: 两种可能的括号方法是
 * 1^(0|(0|1))
 * 1^((0|0)|1)
 * 示例 2:
 *
 * 输入: s = "0&0&0&1^1|0", result = 1
 *
 * 输出: 10
 * 提示：
 *
 * 运算符的数量不超过 19 个
 * </p>
 *
 * @author hongjh
 * @since 2020/9/23
 */
public class BooleanEvaluationLCCI {

    public int countEval(String s, int result) {
        int len = s.length();
        char[] chars = s.toCharArray();
        // 构造一个三维数组 arr[i][j][r] i代表表达式的左界限 j代表表达式的右界限
        // 因为是布尔运算 所有只有四种情况（00，01，10，11）不论运算符，它们只代表两种结果 0和1 所以r代表着这两种结果类型
        // 每个槽中存放着 表达式从i到j的表达式值为r的数量
        int[][][] arr = new int[len][len][2];

        // 遍历所有表达式可能性组合
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                // 遍历当前表达式 遇到运算符就进行运算，最开始的一次和最后一次循环的相同游标不做运算，直接判断
                if (i == j) {
                    arr[i][j][0] = chars[i] == '0' ? 1 : 0;
                    arr[i][j][1] = chars[i] == '1' ? 1 : 0;
                } else {
                    for (int k = i; k < j; k++) {
                        char ch = chars[k];
                        // 主问题分解为子问题，可抽象成例如 左边表达式结果为0 乘以 右边表达式结果为0 得到 当前表达式运算为0的各种优先级运算组合数量结果
                        // 左右边表达式的区分使用 chars[k] 的运算符来区分
                        if (ch == '&' || ch == '|' || ch == '^') {
                            // 由于是布尔运算 所以一边的结果只有0和1 即四种可能
                            for (int left = 0; left <= 1; left++) {
                                for (int right = 0; right <= 1; right++) {
                                    // 计算当前被划分成左右表达式的值 为0则将左右运算式各自当前值的计算组合数量相乘 加进 当前划分的从i到j的表达式为0的槽中
                                    // 为1同理
                                    if (calcExpressionValue(ch, left, right) == 0) {
                                        arr[i][j][0] += arr[i][k - 1][left] * arr[k + 1][j][right];
                                    } else {
                                        arr[i][j][1] += arr[i][k - 1][left] * arr[k + 1][j][right];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return arr[0][len - 1][result];
    }

    /**
     * 计算当前表达式的值 只有三种运算符的可能
     */
    private int calcExpressionValue(char op, int left, int right) {
        if (op == '^') {
            return left ^ right;
        } else if (op == '|') {
            return left | right;
        } else {
            return left & right;
        }
    }

}
