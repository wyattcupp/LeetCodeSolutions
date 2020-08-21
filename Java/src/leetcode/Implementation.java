package leetcode;


import java.lang.Math;
import java.util.*;

/**
* @author WyattCupp
* wyattcupp@gmail.com
**/
public class Implementation {

	/* #202 Happy Number - EASY*/
	/* https://leetcode.com/problems/happy-number/ */
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

    /* #136 Single Number - EASY*/
    /* https://leetcode.com/problems/single-number/ */
    /* O(n) solution */
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

        return Integer.MIN_VALUE; // no single number
    }

    /* #53 Maximum Subarray - EASY*/
    /* https://leetcode.com/problems/maximum-subarray/ */
    /* O(n) solution */
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

    /* #238 Move Zeroes - EASY*/
    /* https://leetcode.com/problems/move-zeroes/ */
    /* O(n) solution */
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

    /* #122 Best Time to Buy and Sell Stock II - EASY*/
    /* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/ */
    /* O(n) solution */
    public static int maxProfit(int[] prices) {
    	int profit = 0; // accumulation of all high points-low points summation
    	int high = prices[0];
    	int low = prices[0];

    	for(int i = 0; i < prices.length-1; i++) {
    		for(int j = i; j < prices.length-1 && prices[j] >= prices[j+1]; j++){ //find low point
    			i++;
    		}
    		low =prices[i];
    		for(int y = i; y < prices.length-1 && prices[y] <= prices[y+1]; y++) { // find high point immediately following low point
    			i++;
    		}
    		high = prices[i];
    		profit += high-low;
    	}
    	return profit;
    }


    /* #49 Group Anagrams - MEDIUM */
    /* https://leetcode.com/problems/group-anagrams/ */
    /* Approx. O(n log(k)) where n is length of array and k is length of each string */
    public static List<List<String>> groupAnagrams(String[] strs) {
    	if(strs.length == 0) return new ArrayList<>();
    	List<List<String>> results = new ArrayList<>();
    	Map<String, List> map = new HashMap<>();

    	for(String s : strs) {
    		char[] c = s.toCharArray();
    		Arrays.sort(c); // sort each string to be used as key value for map
    		String sortedStr = new String(c);
    		
    		if(!map.containsKey(sortedStr)){ 
    			List<String> innerList = new ArrayList<>();
    			innerList.add(s);
    			map.put(sortedStr, innerList);
    			continue;
    		}
    		map.get(sortedStr).add(s);
    	}

    	for(String s : map.keySet()) {
    		results.add(map.get(s));
    	}
    	return results;
    }


    /* #867 Middle of the Linked List - EASY */
    /* https://leetcode.com/problems/middle-of-the-linked-list/ */
    /* O(n/2) solution */
    public ListNode middleNode(ListNode head) {
    	ListNode slow = head; //double pointer problem, use a slow and fast pointer to find middle of list
    	ListNode fast = head;

    	while(fast.next != null ) {
    		if(fast.next.next != null) {
    			slow = slow.next;
    			fast = fast.next.next;
    		}else {
    			slow = slow.next;
    			break;
    		}
    	}
    	return slow;
    }

    /* #844 Backspace String Compare - EASY */
    /* https://leetcode.com/problems/backspace-string-compare/ */
    /* O(n) solution */
    public static boolean backspaceCompare(String S, String T) {
    	Stack<Character> s = new Stack<>(); //use a stack to control the backspace property through pop() when needed

    	for(char c : S.toCharArray()) { //Construct String S
    		if(c != '#') {
    			s.push(c);
    		} else if (!s.empty()) {
    			s.pop();
    		}
    	}

    	String first = s.toString();
    	s = new Stack<Character>(); //reset Stack

    	for(char c : T.toCharArray()) { //Construct String T
    		if(c != '#') {
    			s.push(c);
    		} else if (!s.empty()) {
    			s.pop();
    		}
    	}

    	String second = s.toString();
    	return first.equals(second); // return boolean result of comparison
    }

    /* #543 Diameter of Binary Tree - EASY */
    /* https://leetcode.com/problems/diameter-of-binary-tree/ */
    /* O(?) solution */
    public static int diameterOfBinaryTree(TreeNode root) {
        int ans = 0;

        return diameterOfBinaryTreeHelper(0, root);
    }
    /* #543 Recursive helper function */
    private static int diameterOfBinaryTreeHelper(int depth, TreeNode node) {
        if(node == null) return 0;
        int left = diameterOfBinaryTreeHelper(++depth, node.left);
        int right = diameterOfBinaryTreeHelper(depth-1, node.right);
        return Math.max(left, right)-1; 
    }

    /* #520 Detect Capital - EASY */
    /* https://leetcode.com/problems/detect-capital/ */
    /* O(n) solution */
    public boolean detectCapitalUse(String word) {
        boolean first = Character.isUpperCase(word.charAt(0));
        boolean all = true;
        boolean none = true;
        
        //all capital check
        for(int i = 0; i < word.length(); i++) {
            if(!Character.isUpperCase(word.charAt(i))) {
                all = false;
                break;
            }
        }
        if(all) return true;
        
        //none capital check
        for(int i = 0; i < word.length(); i++) {
            if(!Character.isLowerCase(word.charAt(i))) {
                none = false;
                break;
            }
        }
        
        if(none) return true;
        
        //first capital check
        if(first) {
            for(int i = 1; i < word.length(); i++) {
                if(Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* #125 Valid Palindrome - EASY */
    /* https://leetcode.com/problems/valid-palindrome/ */
    /* O(n) solution */
   public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        
        String forward = "";
        for(int i = 0; i < s.length(); i++) {
            if(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i)))
                forward += "" + s.charAt(i);
        }
        
        String backward = "";
        for(int i = s.length()-1; i >= 0; i--) {
            if(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i)))
                backward += "" + s.charAt(i);
        }
        
        return forward.equalsIgnoreCase(backward);
    }




}







































