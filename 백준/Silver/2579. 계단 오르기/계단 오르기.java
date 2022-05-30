import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int [] arr =new int [N+1];
        int [] dp = new int [N+1];
        
        for(int i = 1 ;i<=N;i++){
            int num=Integer.parseInt(br.readLine());
            arr[i]=num;
          
        }
        //index = 0 , 0 이라 생각하고 
        //값을 1칸 부터 1을 넣자
        
        dp[1]=arr[1];
        
        if(N>=2){
            dp[2]=arr[1]+arr[2];
        }
      
        
        for(int  i= 3 ; i<=N;i++){
            dp[i]=Math.max(dp[i-2],arr[i-1]+dp[i-3])+arr[i];
        }
        System.out.println(dp[N]);
     
    }
}
