import java.util.*;
import java.io.*;

public class Main{
    
    static  Integer [] dp ,arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        dp=new Integer[N];
        arr=new Integer[N];
        
        for(int i =0 ; i<N;i++){
            
            arr[i] = Integer.parseInt(br.readLine());
            
        }
        dp[0]=arr[0];
        if(N>1){
              dp[1]=arr[1]+arr[0];
        }
      
        if(N>2){
            dp[2]=Math.max( Math.max(arr[1]+0,dp[0])+arr[2] ,dp[1] );
        }
        System.out.println(recur(N-1));
        
    }
    static int recur(int N){
        
        if(dp[N]==null){
            dp[N]=Math.max( Math.max( recur(N-2), arr[N-1]+recur(N-3) )+arr[N], recur(N-1) );
        }
        return dp[N];
    }
}
