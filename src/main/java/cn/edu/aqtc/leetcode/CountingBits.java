package cn.edu.aqtc.leetcode;

/**
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * @Description:
 * @ClassName: CountingBits
 * @Author: zhangjj
 * @Date: 2021-03-03
 */
public class CountingBits {

    public static int[] countBits(int num) {

        int[] result = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            String binStr = Integer.toBinaryString(i);
            result[i] = count(binStr);
        }
        return result;

    }

    private static int count(String binStr) {
        int count = 0;
        for (char i : binStr.toCharArray()) {
            if (i == '1') {
                count++;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        int num = 5;
        countBits(num);
    }


}
