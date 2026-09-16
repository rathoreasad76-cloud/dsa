package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class KthLargest {

    private List<Integer> numsList;

    public KthLargest(int k, int[] nums) {
        numsList = new ArrayList<>();
        Arrays.stream(nums).forEach(num -> numsList.add(num));
    }

    public int add(int val) {
        numsList.add(val);
        return 0;
    }

    private void kthLargest(int k) {
        int maxArray[] = new int [k];
        int max = 0;
        if (maxArray.length < k) {
            for (int i = 0; i < numsList.size(); i++) {
                if (max < numsList.get(i)) {
                    max = numsList.get(i);
                    addToMaxArray(maxArray, max);
                }
            }
        }
        //return max;


    }

    private void addToMaxArray(int[] maxArray, int val) {
        for (int i=0; i<maxArray.length; i++) {
            if (maxArray[i] < val) {
                maxArray[i] = val;
            }
        }
    }

}

