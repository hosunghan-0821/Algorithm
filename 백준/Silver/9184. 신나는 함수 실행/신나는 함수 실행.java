import java.util.*;
import java.io.*;

public class Main{
    
    static Integer [][][] arr = new Integer [21][21][21];
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int answer;
        while(true){
            
            StringTokenizer st =new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if(a==-1 && b==-1 && c==-1){
                break;
            }
            
            if(a<=0||b<=0||c<=0){
                answer = 1;
                System.out.println("w("+a+", "+b+", "+c+") "+"= "+answer);
                continue;
            }
            answer=w(a,b,c);
            System.out.println("w("+a+", "+b+", "+c+") "+"= "+answer);
        }
       
    }
    
    public static int w(int a, int b , int c){
        
        if(a>20||b>20||c>20){
            return w(20,20,20);
        }
        
        if(a<=0||b<=0||c<=0){
            return 1;
        }
        
        if(arr[a][b][c]==null){
            if(a<b && a<c){
                arr[a][b][c]=w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
                return arr[a][b][c];
            }
            else{
                arr[a][b][c]=w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
                return arr[a][b][c];
            }
        }
        else{
            return arr[a][b][c];
        }

    }
}
