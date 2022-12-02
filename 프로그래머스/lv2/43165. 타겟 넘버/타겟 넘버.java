class Solution {
    
    int index;
    int answer = 0;
    public int solution(int[] numbers, int target) {
        
        
        int startPlus = numbers[0];
        int startMinus = -numbers[0];

        index = numbers.length;
        DFS(startPlus,1, numbers,target);
        DFS(startMinus, 1,numbers,target);
        return answer;
    }
    public void DFS(int start , int depth,int[] numbers,int target){

        if(start== target && depth==index){
            answer++;
            return;
        }
        if(depth==index){
            return;
        }
        DFS(start+numbers[depth],depth+1,numbers,target);
        DFS(start-numbers[depth],depth+1,numbers,target);
    }
    
}