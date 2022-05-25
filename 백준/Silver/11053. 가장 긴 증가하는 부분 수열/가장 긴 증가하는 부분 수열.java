import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        int [] arr = new int [N];
        int [] dp = new int[N];
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        int i=0;
        while(st.hasMoreTokens()){
            
            arr[i]=Integer.parseInt(st.nextToken());
            i++;
            
        }
        
        for(i=0;i<arr.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                
                if( arr[i]>arr[j] && dp[i]<dp[j]+1 ){
                    dp[i]=dp[j]+1;
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[N-1]);
    }
}
