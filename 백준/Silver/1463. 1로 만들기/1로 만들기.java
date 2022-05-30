import java.util.*;
import java.io.*;

public class Main{
    
    static Integer[] dp;
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        dp  = new Integer[N+1];
        dp[0]=dp[1]=0;
        System.out.print(recur(N));
    }
    static int recur(int N){
        if(dp[N]==null){
            
            //6으로 나뉘어 떨어질 때,
            if(N%6==0){
                dp[N]= Math.min(Math.min(recur(N-1),recur(N/3)), recur(N/2)) +1;
            }
            //3으로 나뉘어 떨어질 때,
            else if(N%3==0){
                dp[N]= Math.min(recur(N/3),recur(N-1))+1;
            }
            //2로 나뉘어 떨어질 때,
            else if (N%2==0){
                dp[N]=Math.min(recur(N/2),recur(N-1))+1;
            }
            else{
                dp[N]=recur(N-1)+1;
            }
        }
        return dp[N];
    }
}
