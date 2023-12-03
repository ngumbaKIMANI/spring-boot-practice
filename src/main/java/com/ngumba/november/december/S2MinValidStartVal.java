package com.ngumba.november.december;

public class S2MinValidStartVal {

    public static int minStartValue1(int[] nums) {
        int minVal = 0;
        int total = 0;

        for (int num : nums) {
            total += num;
            minVal = Math.min(minVal, total);
        }

        // We have to let the minimum step-by-step total equals to 1,
        // by increasing the startValue from 0 to -minVal + 1,
        // which is just the minimum startValue we want.
        return -minVal + 1;
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{-3, 2, -3, 4, 2};
        int[] nums = new int[]{1, 2, -4};
        System.out.println(minStartValue1(nums));
        //System.out.println(minStartValue2(nums));
    }

    public static int minStartValue2(int[] nums) {
        // Start with startValue = 1.
        int startValue = 1;

        // While we haven't found the first valid startValue
        while (true) {
            // The step-by-step total equals startValue at the beginning.
            // Use boolean parameter "isValid" to record whether the total
            // is larger than or equal to 1.
            int total = startValue;
            boolean isValid = true;

            // Iterate over the array "nums".
            for (int num : nums) {
                // In each iteration, calculate "total"
                // plus the element "num" in the array.
                total += num;

                // If "total" is less than 1, we shall try a larger startValue,
                // we mark "isValid" as "false" and break the current iteration.
                if (total < 1) {
                    isValid = false;
                    break;
                }
            }

            // If "isValid" is true, meaning "total" is never less than 1 in the
            // iteration, therefore we return this "startValue". Otherwise, we
            // go ahead and try "startValue" + 1 as the new "startValue".
            if (isValid) {
                return startValue;
            } else {
                startValue += 1;
            }
        }
    }
}

