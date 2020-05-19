import java.lang.Math;
import java.util.*;

/**
* @author WyattCupp
* wyattcupp@gmail.com
**/
public class Implementation {
	

	/* #202 Happy Number - EASY*/
	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		int sum, remainder = 0;

		while(set.add(n)) {
			sum = 0;
			while(n > 0) {
				remainder = n % 10;
				sum += Math.pow(remainder, 2);
				n /= 10;
			}
			if(sum == 1) return true;
			n = sum;
		}
		return false;
    }


    /* Single Number - EASY*/
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums) {
        	if(map.get(i) == null) {
        		map.put(i, 1);
        	}
        	else {
        		int temp = map.get(i);
        		map.put(i, ++temp);
        	}
        }

       for(int i : nums) { // second iteration to check for nums that appear once
       		if(map.get(i) == 1) return i;
       }

        return -1; // no single number
    }

    /* Maximum Subarray */
    public static int maxSubArray(int[] nums) {
    	if(nums.length == 1) return nums[0]; // base case

    	int max = nums[0];
    	int curr = nums[0];

        for(int i = 0; i < nums.length-1; i++) {
        	curr = curr <= 0 ? nums[i+1] : curr+nums[i+1];
        	max = curr > max ? curr : max;
        }
        return max;
    }

    /* Move Zeroes */
    public static void moveZeroes(int[] nums) {
    	//In-Place approach:

    	int k = 0;
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i] == 0) continue;

    		//bubble zeroes to end of array while maintaining in-place property
    		int temp = nums[i];
    		nums[i] = nums[k];
    		nums[k] = temp;
    		k++;
    	}
    }


    
}