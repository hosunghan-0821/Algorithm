import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0 ; i<arr.length; i++){
            if(arr[i]%divisor ==0){
                answer.add(arr[i]);
            }
        }
        if(answer.size()==0){
            answer.add(-1);
        }
        Collections.sort(answer);
        int real_answer[] = new int[answer.size()];
      
        for(int i = 0 ; i <answer.size();i++){
            real_answer[i]=answer.get(i);
        }
        return real_answer;
    }
}