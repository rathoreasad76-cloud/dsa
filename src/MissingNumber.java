public class MissingNumber {
    public int missingNumber(int[] nums) {

        int n = nums.length;
        for (int i=0; i<=n; i++) {
            for (int j=0; j<n; j++) {
                if (nums[j] == i) {
                    break;
                }
                if (j == n-1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int missingNumber2(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int i = 0;
        while (i < max) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
