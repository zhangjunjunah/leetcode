package cn.edu.aqtc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * @Description:
 * @ClassName: IntersectionOfTwoArrays
 * @Author: zhangjj
 * @Date: 2020-11-02
 */
public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        //排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //定义指针
        int n1 = 0;
        int n2 = 0;
        int pre = -1;
        List<Integer> result = new ArrayList<>();
        while (true) {
            int n1Length = nums1.length;
            int n2Length = nums2.length;
            if (n1 >= n1Length || n2 >= n2Length) {
                break;
            }

            if (nums1[n1] < nums2[n2]) {
                n1++;
            } else if (nums1[n1] > nums2[n2]) {
                n2++;
            } else if (nums1[n1] == nums2[n2] && pre != nums1[n1]) {
                pre = nums1[n1];
                n1++;
                n2++;
                result.add(pre);
                continue;
            } else {
                n1++;
                n2++;
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 2, 1};
        int[] num2 = new int[]{2, 2};
        int[] result = intersection(num1, num2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
