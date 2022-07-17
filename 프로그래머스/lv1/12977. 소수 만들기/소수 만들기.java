import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> sum_set = new HashSet<Integer>();
        ArrayList<Integer> sum_list = new ArrayList<>();
        int answer = 0;
        int n = nums.length;
        int r = 3;
        
        combination(nums,n,r,0,set,sum_list);
        for(int sum_num : sum_list){
            System.out.println(sum_num);
            if(check_prime_number(sum_num)){
                answer++;
            }
        }
        return answer;
    }
    public void combination(int[] array , int n , int r , int index , HashSet<Integer> set ,ArrayList<Integer> sum_list){
        if (r == 0 ){
            int sum = 0 ;
            for(int num : set){
                sum+=num;
            }
            sum_list.add(sum);
            return;
        }
        
        for (int i = index ; i <n ; i ++ ){
            set.add(array[i]);
            combination(array,n,r-1,i+1,set,sum_list);
            set.remove(array[i]);
        }
    }
    
    public boolean check_prime_number(int num ){
        boolean check=true ;
        for(int i = 2 ; i <= Math.sqrt(num); i ++){
            if (num % i == 0){
                return false;
            }
        }
        return check;
    }
}