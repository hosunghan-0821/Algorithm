import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        Queue<Integer> que = new LinkedList<Integer>();
        int latest_num = -1;
        for (int  i = 0 ; i < arr.length;i++){
            if(que.size()!=0){
                if(latest_num!=(arr[i])){
                    que.add(arr[i]);
                    latest_num=arr[i];
                }
            }
            else{
               
                que.add(arr[i]);
                latest_num=arr[i];
            }

        }
        int[] answer = new int[que.size()];
        int que_size= que.size();
        for(int i = 0 ; i<que_size;i++){
            answer[i]=que.poll();
            //System.out.println("i : "+i+" que:poll() :" +que.poll() );
        }

        return answer;
    }
}