import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashMap<Integer,Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            map.put(Integer.parseInt(st.nextToken()),1);
        }
        st = new StringTokenizer(br.readLine()," ");
        
        for(int i=0; i<M ;i++){
            
            int num = Integer.parseInt(st.nextToken());
            
            if( map.containsKey(num) ){
                map.put(num,map.get(num)+1);    
            }
            else{
                map.put(num,1);
            }
        }
        int answer=0;
        for(Map.Entry<Integer,Integer> elem : map.entrySet()){
            if(elem.getValue()==1){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
