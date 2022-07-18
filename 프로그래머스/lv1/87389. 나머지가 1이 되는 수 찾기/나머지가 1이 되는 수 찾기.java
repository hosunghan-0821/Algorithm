import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        answer =find_divider(n-1);
        return answer;
    }
    public int find_divider(int n){
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                arr.add(i);
                arr.add(n/i);
            }
                
        
        }
        for(int i = 0 ; i<arr.size();i++){
              System.out.println(arr.get(i));
        }
        Collections.sort(arr);
      
        //return 0 ;
        return arr.get(1); 
    }
}