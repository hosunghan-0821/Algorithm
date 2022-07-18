import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        //원하는 값에 -1 을 하고 나눈 약수중 1을 제외한 숫자중 제일작은 수를 구하면됨.
        answer =find_divider(n-1);
        return answer;
    }
    //주어진 값의 약수를 저장하고 1보다 큰 약수중 제일 작은수를 return 하는
    public int find_divider(int n){
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                arr.add(i);
                arr.add(n/i);
            }
        }
        Collections.sort(arr);
        return arr.get(1); 
    }
}