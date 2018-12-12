package myleetcode;

/**
 * 字符串相乘
 * @author HJH
 *
 * @date 2018年11月30日
 */
public class MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiply("17039"
				,"7218"));
	}
	
	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0") || num1.length() == 0 || num2.length() == 0) {
			return "0";
		}
		int hopeIndex = num1.indexOf("0", 0), curIndex = hopeIndex;
		if (hopeIndex == 0) {
			hopeIndex ++;
			while (num1.indexOf("0", hopeIndex) == curIndex + 1) {
				curIndex = hopeIndex;
				hopeIndex ++;
			}
			num1 = num1.substring(hopeIndex, num1.length());
		}
		hopeIndex = num2.indexOf("0", 0);
		curIndex = hopeIndex;
		if (hopeIndex == 0) {
			hopeIndex ++;
			while (num2.indexOf("0", hopeIndex) == curIndex + 1) {
				curIndex = hopeIndex;
				hopeIndex ++;
			}
			num2 = num2.substring(hopeIndex, num2.length());
		}
		char[] ch1 = num1.toCharArray(), ch2 = num2.toCharArray();
		int len1 = ch1.length, len2 = ch2.length, count, times = 1, lastIndex = 0;
		String result = "";
		StringBuilder builder = new StringBuilder();
		if (len1 > len2) {
			count = len2;
			while (count != 0) {
				builder.setLength(0);
				String resultTemp = "";
				Integer a = Integer.valueOf(String.valueOf(ch2[count---1])), acount = 0, sum;
				for (int i = ch1.length - 1; i >= 0; i--) {
					Integer b = Integer.valueOf(String.valueOf(ch1[i]));
					sum = b * a + acount;
					acount = sum / 10;
					resultTemp += sum % 10;
				}
				if (acount != 0) {
					resultTemp += acount;
				}
				resultTemp = builder.append(resultTemp).reverse().toString();
				builder.setLength(0);
				if (result.length() > 0) {
					char[] rt = resultTemp.toCharArray(), rs = result.toCharArray();
					Integer ac = 0;
					for (int i = rs.length - 1 - times++, j = rt.length - 1; i >= 0; i--, j--) {
						Integer t = Integer.valueOf(String.valueOf(rt[j])), s = Integer.valueOf(String.valueOf(rs[i]));
						int sm = t + s + ac, temp = sm % 10;
						lastIndex = j - 1;
						ac = sm / 10;
						rs[i] = (char) (rs[i] + (temp - s));
					}
					if (ac != 0) {
						for (int i = lastIndex; i >= 0; i--) {
							Integer f = Integer.valueOf(String.valueOf(rt[i]));
							int sm = f + ac, temp = sm % 10;
							if (builder.length() != 0) {
								resultTemp = builder.insert(0, temp).toString();
							} else {
								resultTemp = builder.append(rs).insert(0, temp).toString();
							}
							ac = sm / 10;
						}
						if (ac != 0) {
							if (builder.length() != 0) {
								result = builder.insert(0, ac).toString();
							} else {
								result = builder.append(rs).insert(0, ac).toString();
							}
						} else {
							result = resultTemp;
						}
						continue;
					}
					builder.setLength(0);
					String string = String.copyValueOf(rt, 0, rt.length + times -1 - rs.length);
					resultTemp = builder.append(rs).insert(0, string).toString();
				} 
				result = resultTemp;
			}
		} else {
			count = len1;
			while (count != 0) {
				builder.setLength(0);
				String resultTemp = "";
				Integer a = Integer.valueOf(String.valueOf(ch1[count---1])), acount = 0, sum;
				for (int i = ch2.length - 1; i >= 0; i--) {
					Integer b = Integer.valueOf(String.valueOf(ch2[i]));
					sum = b * a + acount;
					acount = sum / 10;
					resultTemp += sum % 10;
				}
				if (acount != 0) {
					resultTemp += acount;
				}
				resultTemp = builder.append(resultTemp).reverse().toString();
				builder.setLength(0);
				if (result.length() > 0) {
					char[] rt = resultTemp.toCharArray(), rs = result.toCharArray();
					Integer ac = 0;
					for (int i = rs.length - 1 - times++, j = rt.length - 1; i >= 0; i--, j--) {
						Integer t = Integer.valueOf(String.valueOf(rt[j])), s = Integer.valueOf(String.valueOf(rs[i]));
						int sm = t + s + ac, temp = sm % 10;
						lastIndex = j - 1;
						ac = sm / 10;
						rs[i] = (char) (rs[i] + (temp - s));
					}
					if (ac != 0) {
						for (int i = lastIndex; i >= 0; i--) {
							Integer f = Integer.valueOf(String.valueOf(rt[i]));
							int sm = f + ac, temp = sm % 10;
							if (builder.length() != 0) {
								resultTemp = builder.insert(0, temp).toString();
							} else {
								resultTemp = builder.append(rs).insert(0, temp).toString();
							}
							ac = sm / 10;
						}
						if (ac != 0) {
							if (builder.length() != 0) {
								result = builder.insert(0, ac).toString();
							} else {
								result = builder.append(rs).insert(0, ac).toString();
							}
						} else {
							result = resultTemp;
						}
						continue;
					}
					builder.setLength(0);
					String string = String.copyValueOf(rt, 0, rt.length + times -1 - rs.length);
					resultTemp = builder.append(rs).insert(0, string).toString();
				} 
				result = resultTemp;
			}
		}
		return result;
	}
}
