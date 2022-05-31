import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        int [] arr = new int [N];
        int [] LIS = new int[N];
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        int k=0;
        while(st.hasMoreTokens()){
            
            arr[k]=Integer.parseInt(st.nextToken());
            k++;
        }
        //0번에 일단 값 대입하고 시작
        LIS[0]=arr[0];
       
        // 아이디어 값을 차례대로 작은 값을 넣는다. 만약 이전 값보다 작다면, 이진탐색 lower bound를 통해 
        // 가까운 수 들중 첫번째로 큰 수와 교체한다.
        // 이 방식은 수열의 길이를 구할 때만 유효하다.
        
         int LISLength = 1;
        
        for(int i=1;i<N;i++){
            int key = arr[i];
            //원하는대로 증가하는 수열일 경우. 
            if(LIS[LISLength-1]<key){
                LIS[LISLength]=key;
                LISLength++;
            }
            //아닐 경우 대치 이분탐색을 통해 근처값들 중 
            else{
                int lo=0;
                int hi=LISLength;
                //lowerbound를 통해서.
                while(lo<hi){
                    int mid = (lo+hi)/2;
                    if(key<=LIS[mid]){
                        hi=mid;
                    }
                    else{
                        lo=mid+1;
                    }
                }
                LIS[lo]=key;
            }
        }
        System.out.println(LISLength);
    }
}
