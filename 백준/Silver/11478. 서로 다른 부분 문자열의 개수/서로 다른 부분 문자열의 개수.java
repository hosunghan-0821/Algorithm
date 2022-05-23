import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map =new HashMap<>();
        
        String str= br.readLine();
        
        for(int i=1;i<=str.length();i++){
            for(int j=0; j<str.length();j++){
                
                if(j+i>str.length()){
                    break;
                }
                String subString = str.substring(j,j+i);
                map.put(subString,0);
            }
        }
        
        System.out.println(map.size());
    }
}
