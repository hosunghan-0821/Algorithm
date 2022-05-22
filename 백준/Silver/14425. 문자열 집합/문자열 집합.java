import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        
        ArrayList <String> S = new ArrayList<>();
        ArrayList<String> check = new ArrayList<>();
        
        for(int i =0; i< N;i++){
            S.add(br.readLine());
        }
        int answer =0;
        for(int i=0;i<M;i++){
            if(S.contains(br.readLine())){
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}
