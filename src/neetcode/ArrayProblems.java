package neetcode;

public class ArrayProblems {


    public boolean hasDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if ((nums[i] ^ nums[j]) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ArrayProblems arrayProblems = new ArrayProblems();
        int[] nums = {1,2,3,1,2,3};
        System.out.println(arrayProblems.hasDuplicate(nums));
    }


}
