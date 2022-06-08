import java.util.*;
import java.io.*;

public class Main{
    static int[] W,V;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        StringTokenizer st; 
        st = new StringTokenizer(br.readLine()," ");
        int N =Integer.parseInt( st.nextToken() );
        int K =Integer.parseInt( st.nextToken() ) ;
        
        W= new int[N];
        V= new int[N];
        
        dp= new Integer[N][K+1];
  
        for(int i = 0 ; i< N ;i++){
            
            st = new StringTokenizer(br.readLine()," ");
            W[i]=Integer.parseInt(st.nextToken());
            V[i]=Integer.parseInt(st.nextToken());
            
        }

        System.out.println(knapsack(N-1,K));
        
    }
    static int knapsack(int i,int k){
        
        //i=0 미만 범위 밖일 경우 
        if(i<0){
            return 0;
        }
        
        if(dp[i][k]==null){
            //현재 물건(i)를 추가로 못담는 경우 이전 i 값을 사용
            if(W[i]>k){
                dp[i][k]=knapsack(i-1,k);
            }
            //현재 물건 (i)를 담을 수 있다면 비교해서 가치가 큰것을 해야겟지?
            //이전 물건의 가치 vs 현재 물건가치  + 남는 무게의 물건의 가치
            else{
               dp[i][k]=Math.max( knapsack(i-1,k), V[i]+knapsack(i-1,k-W[i]));
            }
        }
        return dp[i][k];
    }
}
