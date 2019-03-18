package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:1. 两数之和
 *
 * 题目来源于 LeetCode 上第 1 号问题： Two Sum。
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 *
 * 所以返回 [0, 1]
 *
 * @Author: liuweixin
 * @Date: 2019/3/16
 * @Time: 13:59
 */
public class TwoSumSolution {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ret = getwoNum(nums, target);
        if(ret != null && nums.length > 0){
            for (int i = 0;i < ret.length;i++){
                System.out.println(ret[i]);
            }
        }
    }

    public static int[] getwoNum(int[] array,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i< array.length;i++){
            int complement = target - array[i];
            map.put(array[i],i);
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[]{map.get(complement),i};
            }
        }
        return new int[]{};
    }
}
