import java.util.*;
import java.io.*;

public class Main{
    
    static long[] house;
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        house=new long[N];
        
        for(int i=0;i<N;i++){
            house[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);
        
        long lo = 1;
        long hi = house[N-1];
        //공유기 갯수에 따른 최대거리를 탐색해서 거리가 M 초과인 upper bound -1 해서 답을 얻는 구조..? 
        while(lo<hi){
            long mid =(lo+hi)/2;
            
            if(installNum(mid)<M){
                hi=mid;
            }
            else{
                lo=mid+1;
            }
        }
        System.out.println(lo-1);
    }
    public static int installNum(long distance){
        long firstHouse = house[0];
        int count =1;
        for(int i =1; i<house.length;i++){
            
            if(house[i]-firstHouse  >=distance){
                firstHouse= house[i];
                count++;
            }
            else{
                
            }
        }
        return count;
    }
}
