import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
       
        int N =  Integer.parseInt(st.nextToken());
        int M =  Integer.parseInt(st.nextToken());
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i=0;i<N;i++){
            map.put(br.readLine(),0);    
        }
        for(int i=0;i<M;i++){
           
            String str = br.readLine();
            if(map.containsKey(str)){
                arrayList.add(str);
            }
            
        }
        System.out.println(arrayList.size());
        Collections.sort(arrayList);
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<arrayList.size();i++){
            sb.append(arrayList.get(i)+"\n");
        }
        System.out.println(sb);
    }
}
