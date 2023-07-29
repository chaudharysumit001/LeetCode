//Bhai yo galat kasie hai check it

// class Solution {
//     public char nextGreatestLetter(char[] letters, char target) {
//         int start = 0;
//         int end = letters.length-1;
        
//         while(start<= end){
//             int mid = start+(end-start)/2;
            
//             if(letters[mid]<start){
//                 start = mid+1;
//             }
//             else{
//                 end = mid-1;
//             }
//         }
//         return letters[start% letters.length]
// // if (start == letters.length){
// // return letters[0];
// // }
//  
//     }
// }

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;

        while(start<=end) {
            int mid = start + (end-start)/2;

            if (target <letters[mid]) {
                end = mid - 1;
            }
            else {
                    start = mid+1;

            }
        }
        if(start == letters.length){
            return letters[0];
        }
        return letters[start];
    }
}