import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
//         for(int i = 0 ; i<board[i].length;i++){
//             for(int j = 0 ; j < board.length;j++){
                
//             }
//         }
        for(int i = 0 ; i<moves.length;i++){
            int num = moves[i]-1;
            for(int j=0;j<board.length;j++){
                //해당 인형이 존재한다면
                if(board[j][num]!=0){
                    //뽑은 인형이 모아지는 곳이 비어있지 않다면
                    if(!stack.isEmpty()){
                        //가장 위에있는 거랑 뽑은 거랑 비교해서 같으면
                        if(stack.peek()==board[j][num]){
                            stack.pop();
                            answer+=2;
                        }
                        // 다르면 그대로 넣기
                        else{
                            stack.push(board[j][num]);
                        }
                    }
                    else{
                        stack.push(board[j][num]);
                    }
                    board[j][num]=0;
                    break;
                }
            }
        }

            
       
        
        return answer;
    }
}