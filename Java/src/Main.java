public class Main {

	/* Driver to test Solutions */
    public static void main(String[] args) {
    	System.out.println("Leetcode Solutions:\n\n");

    	/* Happy Number Test */
    	System.out.println(Implementation.isHappy(19));

    	/* Single Number Test */
    	// int[] singleNum = {4,1,2,1,2,3,5,3,6,5,6};
    	int[] singleNum = {2,2,1};
    	System.out.println(Implementation.singleNumber(singleNum));

    	/* Maximum Subarray Test */
    	int[] maxSub = {-2,1,-3,4,-1,2,1,-5,4};
    	System.out.println(Implementation.maxSubArray(maxSub));

    	/* Move Zeroes */
    	int[] moveZ = {0,1,0,3,12};
    	Implementation.moveZeroes(moveZ);
    	for(int i : moveZ){
    		System.out.print(i);
    	}
    	System.out.println("\n");
    }
}