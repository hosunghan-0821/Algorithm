import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int [] arr =new int[N];
        int [] dp = new int[N];
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        long max = 0;
        long sum = 0;
        dp[0]=arr[0];
        max = arr[0];
        //dp 배열은 index까지의 arr 의 합을 넣어두는 곳;
        for(int i=1;i<N;i++){
           dp[i]=Math.max(dp[i-1]+arr[i],arr[i]);
           max = Math.max(max,dp[i]);
        }
        System.out.println(max);
        
    }
}
