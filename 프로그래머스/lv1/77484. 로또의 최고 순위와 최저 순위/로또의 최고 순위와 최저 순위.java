import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        ArrayList<Integer> lottos_arr = new ArrayList<>();
        ArrayList<Integer> win_nums_arr = new ArrayList<>();
        
        for(int i = 0 ; i <lottos.length;i++){
            lottos_arr.add(lottos[i]);
            win_nums_arr.add(win_nums[i]);
        }
        Collections.sort(lottos_arr);
        Collections.sort(win_nums_arr);
        int count = 0 ;
        int one_eyedJack=0;
        for(int i = 0 ; i< lottos_arr.size(); i++){
            if(win_nums_arr.contains(lottos_arr.get(i))){
                count++;
            }
            if(lottos_arr.get(i).equals(0)){
                one_eyedJack++;
            }
        }
        System.out.println(count);
        System.out.println(one_eyedJack);
        int min_rank = count;
        int max_rank = count+one_eyedJack;
        int[] answer = new int[2];
        answer[0] = check_rank(max_rank);
        answer[1] = check_rank(min_rank);
        return answer;
    }
    public int check_rank(int count){
        int rank = 0;
        switch(count){
            case 6:
                rank = 1;
                break;
            case 5:
                rank = 2;
                break;
            case 4:
                rank = 3;
                break;
            case 3:
                rank= 4;
                break;
            case 2:
                rank = 5;
                break;
            default :
                rank =6;
                break;
        }
        return rank;
    }
}