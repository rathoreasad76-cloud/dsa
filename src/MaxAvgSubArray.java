import java.util.Arrays;

public class MaxAvgSubArray {
    public double findMaxAverageBruteForce(int[] nums, int k) {
        double maxAvg = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            double sum = 0;
            if (nums.length - i >= k) {
                for (int j = i; j < i+k; j++) {
                    sum += nums[j];
                }
                double avg = sum / k;
                if (maxAvg < avg) {
                    maxAvg = avg;
                }
            }
        }
        return maxAvg;
    }

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        double maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];  // slide the window
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum / k;
    }

    public static void main(String[] args) {
        MaxAvgSubArray maxAvgSubArray = new MaxAvgSubArray();
        int[] nums = {5};
        for (int i = 0; i < nums.length; i++) {
             //System.out.println("nums[i]: "+ (nums[i] + nums[i+1]));
        }
        int k = 1;
        System.out.println(maxAvgSubArray.findMaxAverage(nums, k));
    }
}
