class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int prev_value = 0;
        int value = 0;
        for(int i = 0 ; i <dartResult.length();i++){
            char ch =dartResult.charAt(i);
            //점수 확인 10 일 때 체크
            if(ch - '0'>=0 && ch- '0'<=9){
                if(ch-'0'==1&&  dartResult.charAt(i+1)-'0'==0 ){
                   value =10;
                   i++;
                }
                else{
                    value=ch-'0';
                }
                System.out.println(value);
                continue;
            }
            //S,D,T 구분
            if(ch=='S' || ch == 'D' || ch =='T'){
                switch(ch){
                    case 'S':
                    value=(int)Math.pow(value,1);    
                    break;
                    case 'D':
                    value=(int)Math.pow(value,2);
                    break;
                    case 'T':
                    value=(int)Math.pow(value,3);
                }
                answer +=value;
                if(i+1 <=dartResult.length()-1){
                    if(dartResult.charAt(i+1)!='*'&&dartResult.charAt(i+1)!='#')
                       prev_value = value;
                }
               
                System.out.println("answer : "+answer);
                
            }
            //option * , # 체크
            if(ch=='*' || ch=='#'){
                if(ch=='*'){
                    System.out.println("value : "+value);
                    System.out.println("prev_value"+prev_value);
                    answer += (value+prev_value);
                    prev_value=(value*2);
                }
                else{
                    answer -= (value*2);
                    prev_value= (value*(-1));
                }
               
                System.out.println("option answer : "+answer);
                continue;
            }
            
        }
        return answer;
    }
}