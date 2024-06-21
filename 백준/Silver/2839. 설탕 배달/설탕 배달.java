import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
      
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i=0;
        int kg3=0,kg5=0;
        while(N-(3*i)>0){
            kg5= ( N-(3*i) ) % 5;
            if(kg5==0){
                arrayList.add((N-(3*i))/5+i);
            }
            i++;
        }
        i=0;
        while(N-(5*i)>0){
            kg3= ( N-(5*i) ) %3; 
            if(kg3==0){
                arrayList.add( (N-(5*i))/3 +i );
            }
            i++;
        }
        Collections.sort(arrayList);
        if(arrayList.isEmpty()){
            System.out.println(-1);
        }
        else{
             System.out.println(arrayList.get(0));
        }
       
        
    }
}
