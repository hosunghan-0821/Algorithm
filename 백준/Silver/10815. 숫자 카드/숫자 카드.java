import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList =new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        //String [] str = br.readLine().split(" ");
        for(int i =0;i<N;i++){
            arrayList.add(Integer.parseInt(st.nextToken()));
        }
        //정렬
        Collections.sort(arrayList);
        StringBuilder sb =new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        
        for(int i=0;i<M;i++){
             int temp = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(arrayList,N,temp)+ " "); 
         
        }
      
       System.out.println(sb);
        
    }
    
    public static int binarySearch(ArrayList<Integer> arrayList, int N ,int search){
        
        int first = 0;
        int last = N-1;
        int mid = 0;
        
        while(first<=last){
            mid = (first+last)/2;
            if(arrayList.get(mid)==search){
                return 1;
                
            }
            if(arrayList.get(mid)<search){
                first = mid+1;
            }
            else{
                last= mid-1;
            }
        }
        return 0;
    }
}
