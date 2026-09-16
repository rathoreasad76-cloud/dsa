public class SortedArrayChecker {
    public static void main(String[] args) {

    }

    public boolean isSorted(int[] arr) {
        // code here\
        int first = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < first) {
                return false;
            }
            first = arr[i];
        }
        return true;

    }
}

