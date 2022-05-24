import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        
        //찾는 int[k]=x 에서 x 값은 인덱스 k 값보다 작거나 같다.
        //직접 배열 그려봐라
        
        int lo =1;
        int hi =K;
        
        
        while(lo<hi){
            int mid = (lo+hi)/2;
            int count =0;
            for(int i =1 ; i<=N;i++){
                count += Math.min(mid/i,N);
            }
            if(K<=count){
                hi=mid;
            }
            else{
                lo=mid+1;
            }
        }
        System.out.println(lo);
    }
}
