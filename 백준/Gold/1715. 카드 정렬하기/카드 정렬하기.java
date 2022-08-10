import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
         PriorityQueue<Integer> arr = new PriorityQueue<>();

        for(int i = 0 ; i <N;i++){
            arr.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0 ;
        while(arr.size()>1){
            int sum_num=arr.poll()+arr.poll();
            sum+=sum_num;
       
        
            arr.add(sum_num);
           
        }
        System.out.println(sum);

    }
}
