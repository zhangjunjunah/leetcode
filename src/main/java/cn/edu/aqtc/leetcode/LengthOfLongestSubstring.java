package cn.edu.aqtc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 暴力解法时间复杂度较高，会达到 O(n^2)O(n2)，
 * 故而采取滑动窗口的方法降低时间复杂度
 * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
 * 我们定义不重复子串的开始位置为 start，结束位置为 end
 * 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
 * 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
 * @ClassName: LengthOfLongestSubstring
 * @Author: zhangjj
 * @Date: 2020-05-08
 */
public class LengthOfLongestSubstring {


    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> chLocation = new HashMap<>(s.length());
        int length = s.length();
        for (int start = 0, end = 0; end < length; end++) {
            char ch = s.charAt(end);
            if (chLocation.containsKey(ch)) {
                start = Math.max(start, chLocation.get(ch));
            }
            max = Math.max(max, (end - start + 1));
            chLocation.put(ch, start + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        String test = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(test));
    }


}
