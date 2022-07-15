import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i = 0 ; i <arr.length;i++){
            arrList.add(arr[i]);
        }
        Collections.sort(arrList,Collections.reverseOrder());
        int min_num = arrList.get(arrList.size()-1) ;
        arrList.remove(arrList.size() - 1);
        
        if(arrList.size()==0){
            int[] ans_arr = {-1};
            return  ans_arr;
        }
        else{
            int[] ans_arr = new int[arrList.size()];
            int j = 0 ;
            for(int i = 0 ; i<arr.length;i++){
               if(arr[i]!=min_num){
                   ans_arr[j]=arr[i];
                   j++;
               }
            }
            return ans_arr;
        }

      
    }
}