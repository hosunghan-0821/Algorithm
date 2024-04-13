class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        
        int[][] dp = new int[triangle.length][];
        dp[0]= new int[1];
        dp[0][0] = triangle[0][0];
        for (int i = 1 ; i < triangle.length; i++) {
            dp[i] = new int[i + 1];
            for (int j = 0; j <triangle[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = triangle[i][j] + dp[i-1][0];
                } else if (j == triangle[i].length - 1) {
                    dp[i][j] += triangle[i][j] + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max( triangle[i][j] + dp[i-1][j-1],triangle[i][j] + dp[i-1][j]);
                }
            }
        }
        
        
        for (int i = 0; i < dp[triangle.length -1].length; i++) {
           if (answer < dp[triangle.length - 1][i]) {
               answer = dp[triangle.length - 1][i];
           }
        }
       
   
        return answer;
    }
}