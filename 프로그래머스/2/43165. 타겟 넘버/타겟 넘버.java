class Solution {
    
    public int answer = 0; 
    
    public void dfsRecursive(int[] numbers,int target, int index, int sum){
        if (index == numbers.length) {
            if (sum == target) {
                answer += 1;
            }
            return;
        }
        
        dfsRecursive(numbers,target,index + 1, sum + numbers[index]);

        dfsRecursive(numbers,target,index + 1, sum - numbers[index]);
    }
    
    public int solution(int[] numbers, int target) {
    
        dfsRecursive(numbers,target,0,0);
        return answer;
    }
}