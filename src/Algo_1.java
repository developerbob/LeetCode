import java.util.HashMap;
import java.util.Map;


/**
 * Given an array of integers, return indices of the two numbers such that 
 * they add up to a specific target. 
 * 
 * You may assume that each input would have exactly one solution, and you 
 * may not use the same element twice.
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * Bob Yang 2017-07-09
 */

public class Algo_1 {
	
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        m.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
        	if (m.containsKey(target - nums[i])) {
        		return new int[] {m.get(target - nums[i]), i};
        	} else {
        		m.put(nums[i], i);
        	}
        }
        throw new IllegalArgumentException("No two sum solution");
    }
	
	public static void main(String[] args) {
		Algo_1 a = new Algo_1();
		int[] nums = {2, 7, 11, 15};
		int[] ret = a.twoSum(nums, 9);
		System.out.println("Index 1: " + ret[0]);
		System.out.println("Index 2: " + ret[1]);
	}
}
