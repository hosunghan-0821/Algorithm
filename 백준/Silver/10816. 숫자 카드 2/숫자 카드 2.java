import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int N = Integer.parseInt(br.readLine());
        
        String[] str = br.readLine().split(" ");
     
        for(int i=0;i<N;i++ ){
            int num = Integer.parseInt(str[i]);
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
          
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        str = br.readLine().split(" ");
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(str[i]);
            if(map.get(num)!=null){
                 sb.append(map.get(num)+" ");
            }
            else{
                sb.append(0+" ");
            }
           
        }
        
        System.out.print(sb);
    }
}
