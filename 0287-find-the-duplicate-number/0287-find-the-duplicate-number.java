class Solution {
    public int findDuplicate(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        int ans = 0;
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                ans = arr[index];
            }
        }
        return ans;
    }

    static void swap(int arr[], int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}