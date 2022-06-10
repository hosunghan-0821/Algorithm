import java.util.*;
import java.io.*;

class Solution {

    public int[] solution(String[] id_list, String[] report, int k) {
        
        //답안
        int[] answer = new int[id_list.length];
        //각 아이디별 신고자 아이디 동적으로 배당
        ArrayList<String> [] arr = new ArrayList [id_list.length]; 
        
        // 신고횟수 저장하는 배열
        int[] report_num = new int[id_list.length];
        
        for(int i = 0 ; i<id_list.length;i++){
         arr[i]=new ArrayList<>();
        }
       //report 신고자 : 신고당한사람 나눠서  각각 배열에 할당
        for(int i = 0 ; i<report.length;i++){

          StringTokenizer st = new StringTokenizer(report[i]," ");
          String report_person = st.nextToken();
          String bad_person = st.nextToken();
          boolean check=false;
            
             for(int j = 0 ; j<id_list.length;j++){
                 //신고자가 id
                    if( report_person.equals(id_list[j]) ) {
                        
                        //신고이력이 있을경우 추가
                        if(arr[j].contains(bad_person)){
                            check=true;
                            continue;
                        }
                        //신고이력이 없을경우 추가
                        else{
                           arr[j].add(bad_person);
                        }
                    }
                }
            //신고이력이 없을 경우 신고횟수 누적
            if(!check){
                
                for(int j = 0 ; j <id_list.length; j++ ){
                    if(id_list[j].equals(bad_person)){
                        report_num[j]++;
                    }
                }
            }
              
          }
          
    for(int i = 0 ; i<id_list.length;i++){
    
        if(report_num[i]>=k){
        
            for(int j = 0 ; j<id_list.length;j++){
            
                if(arr[j].contains(id_list[i])){
                    answer[j]++;
                }
                
            }
        }
    }
        
    return answer;
    }
}