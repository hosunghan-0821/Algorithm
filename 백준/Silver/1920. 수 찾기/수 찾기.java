import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int [] arr = new int [N];
        
        for(int i=0; i<N;i++){
           arr[i]=Integer.parseInt(st.nextToken());    
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        Arrays.sort(arr);
        
        for(int i=0;i<M;i++){
            int idx;
            idx=BinarySearch(arr,Integer.parseInt(st.nextToken()));
          if(idx!=-1){
              System.out.println(1);
              
          }
            else{
                System.out.println(0);
            }
        }
    }
    
    public static int BinarySearch(int[] arr , int key){
        int lo = 0;
        int hi = arr.length-1;
        
        while(lo<=hi){
            int mid = (lo+hi)/2 ;
            //key 값이 우측에 있을 경우 lo 올리자
            if(arr[mid]<key){
                lo=mid+1;
            }
            //key 값이 좌측에 있을 경우 
            else if(arr[mid]>key){
                hi=mid-1;
            }
            //key 값이 같을 경우
            else{
                return mid;
            }
        }
        return -1;
    }
}
