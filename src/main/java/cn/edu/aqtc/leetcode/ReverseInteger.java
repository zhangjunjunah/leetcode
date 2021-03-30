package cn.edu.aqtc.leetcode;

/**
 * 7. 整数反转
 * <p>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 *
 * @Description:
 * @ClassName: ReverseInteger
 * @Author: zhangjj
 * @Date: 2021-03-24
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(123));
    }

    public int reverse(int x) {

        int res = 0;
        int maxInt = Integer.MAX_VALUE;
        maxInt = maxInt / 10;
        while (x != 0) {
            int tmp = x % 10;
            x = x / 10;

            if (Math.abs(res) > maxInt || (Math.abs(res) == maxInt && tmp > 7)) {
                return 0;
            }

            res = res * 10 + tmp;
        }
        return res;
    }

}
