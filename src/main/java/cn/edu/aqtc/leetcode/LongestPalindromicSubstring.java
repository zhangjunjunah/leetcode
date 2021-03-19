package cn.edu.aqtc.leetcode;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * @Description:
 * @ClassName: LongestPalindromicSubstring
 * @Author: zhangjj
 * @Date: 2021-03-08
 */
public class LongestPalindromicSubstring {

    /**
     * 暴力破解
     *
     * @param s
     * @throws
     * @return: java.lang.String
     * @Author: zhangjj
     * @Date: 2021-03-08
     */
    public static String longestPalindromeByM1(String s) {
        int max = 0;
        int begin = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (j - i + 1 > max && validPalindromic(chars, i, j)) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + max);
    }

    private static boolean validPalindromic(char[] chars, int i, int j) {
        boolean isTrue = true;
        while (i <= j) {
            if (chars[i] != chars[j]) {
                isTrue = false;
                break;
            }
            i++;
            j--;
        }
        return isTrue;
    }


    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindromeByM1(s));
    }
}
