import java.util.*;
import java.io.*;

public class Main{
    static Long[] arr = new Long[101];
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr[1]=1L;
        arr[2]=1L;
        arr[3]=1L;
        arr[4]=2L;
        arr[5]=2L;
        
        for(int i =0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            System.out.println(p(num));
        }
    }
    
    public static long p(int num){
       
         if(arr[num]==null){
            arr[num]= p(num-1)+p(num-5);
            return arr[num];
        }
        
        if(num<6){
            return arr[num];
        }

       
        return arr[num];
     
        
    }
    
}
