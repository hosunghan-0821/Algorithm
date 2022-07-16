import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] numbers) {
      
        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        for(Integer num : set){
            arr.add(num);
        }
        Collections.sort(arr);
        int[] answer = new int[arr.size()]; 
        for(int i= 0 ; i < arr.size() ; i ++ ){
              answer[i]=arr.get(i);
        }
      
        return answer;
    }
}