import java.util.*;
import java.io.*;

public class Main{
    static int[] W,V;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        StringTokenizer st; 
        st = new StringTokenizer(br.readLine()," ");
        int N =Integer.parseInt( st.nextToken() );
        int K =Integer.parseInt( st.nextToken() ) ;
        
        W= new int[N+1];
        V= new int[N+1];
        dp= new int[K+1];
        
        for(int i = 1 ; i<= N ;i++){
            
            st = new StringTokenizer(br.readLine()," ");
            W[i]=Integer.parseInt(st.nextToken());
            V[i]=Integer.parseInt(st.nextToken());
            
        }

        for(int i=1 ; i<=N;i++){
            //K부터 탐색하여 담을 수 있는 무계 한계치가 넘지 않을 때까지 반복
            for(int j=K; j-W[i]>=0;j--){
                dp[j]=Math.max(dp[j],dp[j-W[i]]+V[i]);
            }
        }
        System.out.println(dp[K]);
 
        
    }
}
