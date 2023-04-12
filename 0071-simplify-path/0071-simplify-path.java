class Solution {
    public String simplifyPath(String path) {
        
        Stack<String> st = new Stack<String>();
        String[] arr= new String[path.length()];
        for(String dirOrfile:path.split("/"))
        {
            if(!dirOrfile.isEmpty() && dirOrfile.equals(".."))
            {
                if(!st.isEmpty())
                {
                     st.pop();
                }
               
            }
            else if(!dirOrfile.equals("..") && !dirOrfile.equals(".") && !dirOrfile.equals(""))
            {
                st.push(dirOrfile);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s:st)
        {
            sb.append("/").append(s);
        }
        return sb.length()==0 ? "/":sb.toString();
    }
}