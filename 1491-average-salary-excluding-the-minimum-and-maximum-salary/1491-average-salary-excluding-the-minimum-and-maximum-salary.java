class Solution {
    public double average(int[] salary) {
        double result = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num: salary) {
            result +=num;

            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return (result - max - min) / (salary.length - 2 ) ;
    }
}