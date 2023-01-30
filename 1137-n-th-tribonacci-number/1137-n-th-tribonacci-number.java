class Solution {
    public int tribonacci(int n) {

        int first = 0,second = 1,third = 1,fourth=0;

        if(n==0)
            return first;

        if(n==1 || n==2)
            return 1;

        for(int i=3;i<=n;i++)
        {
            fourth = first + second + third;
            first = second;
            second = third;
            third = fourth;
        }

        return fourth;
    }
}