import java.util.*;
import java.io.*;

public class Main{
    static int [][] dp;
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N][2];
        
        for(int i = 0 ; i<N ; i ++){
            
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            dp[i][0]=Integer.parseInt(st.nextToken());
            dp[i][1]=Integer.parseInt(st.nextToken());
            
        }
        
        Arrays.sort(dp,new Comparator<int[]>(){
            
            @Override
            public int compare(int [] o1,int[] o2){
                if(o1[1]==o2[1]){
                   return o1[0]-o2[0];     
                }
                return o1[1]-o2[1];
                    
            }
        });
        int count = 0 ;
        int start=0,finish=0;
        for(int i = 0 ; i<N; i++){
            if(finish <=dp[i][0]){
                finish = dp[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
