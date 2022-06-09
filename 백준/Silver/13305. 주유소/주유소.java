import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long distance [] = new long[N-1];
        long price [] = new long[N];
        
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i<N-1 ; i++){
            distance[i]=Long.parseLong(st.nextToken());    
        }
        st = new StringTokenizer(br.readLine()," ");
        
        for(int i = 0 ; i<N;i++){
            price[i]= Long.parseLong(st.nextToken());
        }
        
        long sum = 0 ;
        for(int i = 0 ; i<N-1; i++){
            
            int j = i +1 ;
            sum+= distance[i]*price[i];
            while(price[i]<price[j]){
                sum+=distance[j]*price[i];
                j++;
                if(j>=N-1){
                    break;
                }
            }
            i=j-1;
        }
        System.out.println(sum);
    }
}
