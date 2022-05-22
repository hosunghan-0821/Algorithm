import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String [] strArray = br.readLine().split(" ");
        int N = Integer.parseInt(strArray[0]);
        int M = Integer.parseInt(strArray[1]);
        HashMap<String,String> map = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i =0; i<N;i++){
            String pocketmon = br.readLine();
            map.put(pocketmon,Integer.toString(i+1));
            map.put(Integer.toString(i+1),pocketmon);
        }
        
        for(int i=0;i<M;i++){
        
            String str = br.readLine();
            sb.append(map.get(str)+'\n');
        }
        System.out.print(sb);
    }
}
