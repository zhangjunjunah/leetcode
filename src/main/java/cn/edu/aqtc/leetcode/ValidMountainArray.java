package cn.edu.aqtc.leetcode;

/**
 * 941. 有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * <p>
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：[0,3,2,1]
 * 输出：true
 *
 * @Description:
 * @ClassName: ValidMountainArray
 * @Author: zhangjj
 * @Date: 2020-11-03
 */
public class ValidMountainArray {

    public static boolean validMountainArray(int[] a) {

        int length = a.length;
        int start = 1;
        int end = length - 2;

        while (start <= length - 1 && a[start - 1] < a[start]) {
            start++;
        }

        while (end >= 0 && a[end + 1] < a[end]) {
            end--;
        }

        if (start == end) {
            return true;
        }
        return false;

    }


    public static void main(String[] args) {

        int[] a = new int[]{0, 3, 2, 1};
        System.out.println(validMountainArray(a));
    }

}
