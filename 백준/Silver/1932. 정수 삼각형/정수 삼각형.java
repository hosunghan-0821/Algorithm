import java.util.*;
import java.io.*;

public class Main{
    static int[][] dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        dp=new int[N][N];
        arr = new int[N][N];
      
        // 입력값 차례대로 배열에 담기
        for(int i=0;i<N;i++){
              
            StringTokenizer str = new StringTokenizer(br.readLine()," ");
            int j =0;
            while(str.hasMoreTokens()){
                
               arr[i][j]=Integer.parseInt(str.nextToken());
               j++; 
            
            }   
        }
        for(int i =1 ; i<N;i++){
            
            for(int j =0;j<i+1;j++){
             if(j==0){
                 arr[i][j]+=arr[i-1][0];
             } 
             else if(j==i){
                    arr[i][j]+=arr[i-1][j-1];
             }
             else{
                   arr[i][j]+=Math.max(arr[i-1][j],arr[i-1][j-1]);
             }
           }
        }
        Arrays.sort(arr[N-1]);
        System.out.println(arr[N-1][N-1]);
        
    }
}
