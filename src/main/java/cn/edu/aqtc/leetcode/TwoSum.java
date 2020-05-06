package cn.edu.aqtc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @ClassName: TwoSum
 * @Author: zhangjj
 * @Date: 2020-05-06
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> numMap = new HashMap<>(nums.length);
        for(int i=0;i<nums.length;i++){
            numMap.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int surplus = target-nums[i];
            if(numMap.containsKey(surplus) && numMap.get(surplus)!=i){
                result[0] = i;
                result[1] = numMap.get(surplus);
                return result;
            }
        }
        throw new  IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] arr = {2, 7, 11, 15};
        int target = 13;
        int[] result = twoSum.twoSum(arr,target);
        System.out.println(result[0]+","+result[1]);
    }
}
