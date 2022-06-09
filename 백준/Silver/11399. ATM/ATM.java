import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i <N ;i++){
            arr.add( Integer.parseInt(st.nextToken()));
        }
        //오름차순으로 정렬
        Collections.sort(arr);
        int sum = 0;
        int num = N;
        for(int i =0 ; i<N;i++){
            sum += arr.get(i)*num;
            num--;
        }
        System.out.println(sum);
    }
}
