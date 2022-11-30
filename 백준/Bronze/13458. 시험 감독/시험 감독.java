import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int class_num =  Integer.parseInt(br.readLine());
        int[] student_num = new int[class_num];  
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < class_num ; i ++ ){
             student_num[i] = Integer.parseInt(st.nextToken());
        }
        st= new StringTokenizer(br.readLine()," ");
        int director = Integer.parseInt(st.nextToken());
        int sub_director = Integer.parseInt(st.nextToken());
        
        long total_num = class_num ;
        for(int i = 0 ; i< class_num ; i++){
            int student=student_num[i];
      
            student = student - director;
            if(student > 0 ){
                if (student / sub_director ==0){
                    total_num ++;
                }
                else if (student % sub_director ==0){
                    total_num += (student/sub_director);
                }
                else{
                    total_num += (student/sub_director)+1;
                }
            }
            
        }
        
        System.out.println(total_num);
        
    }
}