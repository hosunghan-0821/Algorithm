import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence;
        Stack<String> stack = new Stack<>();
        while( true){
            sentence=br.readLine();
            if(sentence.equals(".")){
                break;
            }
            stack.clear();
            for(int i=0;i<sentence.length();i++){

                if(sentence.charAt(i)=='['){
                    stack.push("[");
                }
                else if(sentence.charAt(i)=='('){
                    stack.push("(");
                }
                else if(sentence.charAt(i)==')'){
                    if(stack.isEmpty()){
                        stack.push("wrong");
                        break;
                    }
                    if(stack.peek().equals("(")){
                        stack.pop();
                    }
                    else{
                        stack.push("wrong");
                    }

                }
                else if(sentence.charAt(i)==']'){
                    if(stack.isEmpty()){
                        stack.push("wrong");
                        break;
                    }
                    if(stack.peek().equals("[")){
                        stack.pop();
                    }
                    else{
                        stack.push("wrong");
                    }
                }
            }

           

            if( stack.isEmpty()){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }

        }
    }
}
