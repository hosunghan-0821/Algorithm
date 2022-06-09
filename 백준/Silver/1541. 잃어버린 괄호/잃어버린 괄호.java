import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer( br.readLine(),"-|+",true );
        ArrayList<String> arr = new ArrayList<>();
        
        // 숫자,기호를 문자열 형태로 arrayList에 동적을 넣음
        while(st.hasMoreTokens()){
            arr.add(st.nextToken());
        }
        
        //토글로 숫자 문자 숫자 문자 할까?
        int sum=0, temp=0;
        boolean check=false;

        
        for(int i =0 ; i<arr.size();i+=2){
            
            //맨 처음일 경우
            if(i==0){
               sum+=Integer.parseInt(arr.get(i)); 
            }
            
            // 그다음부터;
            else{
                if( arr.get(i-1).equals("+") && !check){
                    sum+=Integer.parseInt(arr.get(i)); 
                }
                else if(arr.get(i-1).equals("-")){
                    check=true;
                    sum-=Integer.parseInt(arr.get(i));
                }
                else if (arr.get(i-1).equals("+") &&check ){
                    sum-=Integer.parseInt(arr.get(i));
                }
            }

        }
        System.out.println(sum);
    }
}
