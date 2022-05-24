import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        
        st =new StringTokenizer(br.readLine()," ");
        
        for(int i=0;i<N;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int lo = 0;
        //나무 길이의 최대 값
        int hi = arr[N-1];
        
        
        //upperbound를 쓰자
        while(lo<hi){
            
            int mid= (lo+hi)/2;
            long sum = 0;
            
            for(int i=0; i<N;i++){
                if(arr[i]-mid>0){
                     sum+= arr[i]-mid;
                }
             
            }
            
            if(sum<M){
                hi=mid;
            }
            else{
                lo=mid+1;
            }
        }
        System.out.println(lo-1);
        
    }
}