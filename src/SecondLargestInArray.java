public class SecondLargestInArray {

    public static void main(String[] args) {

    }

    public int getSecondLargest(int[] arr) {
        // code here
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax && num != firstMax) {
                secondMax = num;
            }
        }
        return secondMax;

    }
}
