import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        //step 1
        new_id=new_id.toLowerCase();
        //step 2
        String new_id_2="";
        for(int i=0 ; i<new_id.length();i++){
            char ch =new_id.charAt(i);
            if( !((ch>='a'&& ch<='z') ||(ch>='0' &&ch<='9') || ch=='-' || ch=='_' || ch=='.')){ 
                new_id_2+="";
            }
            else{
                new_id_2+=ch;
            }
        }
        //step 3
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<new_id_2.length();i++){
            if(stack.empty()){
                stack.push(new_id_2.charAt(i));
                continue;
            }
            if(stack.peek()=='.'&&new_id_2.charAt(i)=='.'){
                continue;
            }
            else{
                stack.push(new_id_2.charAt(i));
            }
        }
        String new_id_3 = "";
        StringBuilder sb =new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        new_id_2 = sb.reverse().toString();
        // System.out.println(new_id_2);

        //step 4
        if( new_id_2.charAt(0) =='.' ){
            System.out.println("첫번째 오류");
           new_id_2 = new_id_2.substring(1);
        }
        System.out.println(new_id_2.length());
        if (new_id_2.length()!=0&&new_id_2.charAt(new_id_2.length()-1)=='.'){
             new_id_2 = new_id_2.substring(0,new_id_2.length()-1);
        }
        
        //step 5
        if(new_id_2.equals("")){
            new_id_2="a";
        }
        //step6
        if(new_id_2.length()>=16){
            new_id_2=new_id_2.substring(0,15);
            if(new_id_2.charAt(new_id_2.length()-1)=='.'){
                new_id_2 = new_id_2.substring(0,new_id_2.length()-1);
            }
        }
        //step7
        if(new_id_2.length()<=2){
            while(new_id_2.length()<3){
                new_id_2+=new_id_2.charAt(new_id_2.length()-1);
            }
        }
        
       
        return new_id_2;
    }
}