package com.ngumba.november;

public class S21MaxOnes {


        public static int findMaxConsecutiveOnes(int[] nums) {
            int max = 0;

            for(int i = 0; i<nums.length - 1; i++){
                if(nums[i]==1 && nums[i+1] == 1){
                    if(max==0){
                        max+=1;
                    }
                }else{
                    Math.max(max,0);
                }
            }

            return max;
        }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }

}
