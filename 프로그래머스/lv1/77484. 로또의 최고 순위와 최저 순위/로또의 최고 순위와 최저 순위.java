import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        ArrayList<Integer> lotto = new ArrayList<>();
        ArrayList<Integer> win_num = new ArrayList<>();
        // ArrayList 로 변경
        for(int i = 0 ; i< lottos.length;i++){
            lotto.add(lottos[i]);
            win_num.add(win_nums[i]);
        }
        Collections.sort(lotto);
        Collections.sort(win_num);
        
        int zero_num=0;
        int min_rank=0;
        int contain_num=0;
        for(int i = 0 ; i <6 ; i ++){
        
            if(lotto.get(i)==0){
                
                zero_num++;
                continue;
            }
            
            if(win_num.contains(lotto.get(i))){
                
                contain_num++;
            }
            
        }
        switch(contain_num){
            case  2:
                min_rank=5;
                break;
            case  3:
                min_rank=4;
                break;
            case  4:
                min_rank=3;
                  break;
            case  5:
                min_rank=2;
                  break;
            case  6:
                min_rank=1;
                break;
            default : 
                min_rank=6;
                break;
        }
        if(zero_num==6) answer[0]=1;
            else answer[0] = min_rank-zero_num;
    
        answer[1] = min_rank;
        return answer;
    }
}