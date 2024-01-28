package com.ngumba.january;

public class RemoveDuplicatesInArrayInplace {

    public static int getUniqueOrderedElements(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] inputArray = {1,1,1,0,2,2,3};
        int uniqueOrderedArray = getUniqueOrderedElements(inputArray);

        // Print the result
        System.out.print("Unique Ordered Elements: ");
        for (int element : uniqueOrderedArray) {
            System.out.print(element + " ");
        }
    }
}
