class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String[] str_num = Integer.toString(x).split("");
        int sum=0;
        for(int i = 0 ; i<str_num.length;i++){
            sum+=Integer.parseInt(str_num[i]);
            
        }
        if(x%sum==0){
            return true;
        }
        else{
            return false;
        }
      
    }
}