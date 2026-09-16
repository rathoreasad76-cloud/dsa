public class MoveZeeros {
    public void moveZeroes(int[] nums) {

        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }


    }

    public void swap(int[] nums, int indA, int indB) {

        int temp = nums[indA];
        nums[indA] = nums[indB];
        nums[indB] = temp;
    }


    public static void main(String[] args) {
        MoveZeeros moveZeeros = new MoveZeeros();
        int[] nums = {0, 1, 0, 3, 12};
        moveZeeros.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
        }
    }
}
