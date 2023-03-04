class Solution {
    public static int compress(char[] chars) {
        String ans = chars[0] + "";
        int len = chars.length;
        int i = 1;
        int count = 0;

        while(i < len){
            count = 1;
            while(i < len && chars[i] == ans.charAt(ans.length()-1)){
                count++;
                i++;
            }
            if(count > 1){
                ans += count;
            }

            if(i < len){
                ans += chars[i];
            }
            i++;
        }
            
            for(int a = 0; a < chars.length; a++)
                chars[a] = ' ';

            // System.out.println(chars.length);
            // System.out.print(ans.length() + "  " + ans);

        for(int j = 0; j < ans.length(); j++){
            chars[j] = ans.charAt(j);
        }

        //  for(int k = 0; k < chars.length; k++){
        //     System.out.print(chars[k] + " ");
        // }

        return ans.length();

    }
}