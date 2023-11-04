// class Solution {
//     public int[] findErrorNums(int[] arr) {
//         int i = 0;
//         while(i < arr.length){
//             int correct = arr[i]-1;
//             if(arr[correct]!= arr[i]){
//                 swap(arr, i , correct);
//             }
//             else{
//                 i++;
//             }
//         }
//         List<Integer> answer = new ArrayList<>();
//         for(int index = 0; index<arr.length ; index++){
//             if(arr[index] != index+1){
//                 answer.add(arr[index]);
//                 answer.add(index+1);
//             }
//         }
//         return answer[0];
//     }
//     static void swap(int arr[] , int first, int second){
//         int temp = arr[first];
//         arr[first] = arr[second];
//         arr[second] = temp;
//     }
// }
class Solution {
    public int[] findErrorNums(int[] arr) {
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[correct] != arr[i]){
                swap(arr, i, correct);
            }
            else{
                i++;
            }
        }
        List<Integer> answer = new ArrayList<>();
        for(int index = 0; index < arr.length; index++){
            if(arr[index] != index + 1){
                answer.add(arr[index]);
                answer.add(index + 1);
            }
        }
        // Convert List<Integer> to int[]
        int[] result = new int[answer.size()];
        for (int index = 0; index < answer.size(); index++) {
            result[index] = answer.get(index);
        }
        return result;
    }

    static void swap(int arr[], int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
