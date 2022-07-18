import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<Stages> arr = new ArrayList<>();
        //Stages 객체 만들어서, 몇번 째 스테이지인지 체크하고 스테이지 배열에 대입
        for(int i = 0 ; i <N ;i++ ){
            Stages stage = new Stages(i+1);
            arr.add(stage);
        }
        //int stages[] 안에 있는 정보를 통해 데이터 추가
        for(int i = 0 ; i <arr.size();i++){
            for(int j = 0 ; j<stages.length;j++){
                
                if(arr.get(i).stage_level<=stages[j]){
                    arr.get(i).allStage_user++;
                }
                if(arr.get(i).stage_level == stages[j]){
                    arr.get(i).inStage_user++;
                }
                
            }
        }
        //
        for(int i = 0 ; i<arr.size();i++){
            double inStage  =  (double)arr.get(i).inStage_user;
            double allStage =  (double)arr.get(i).allStage_user;
            if((int)allStage==0){
                arr.get(i).fail_ratio=0;
            }
            else{
                arr.get(i).fail_ratio = inStage / allStage;
            }
          // System.out.println("stage_level : "+ arr.get(i).stage_level+" inStage : "+arr.get(i).inStage_user+" allStage :"+arr.get(i).allStage_user);
           // System.out.println("fail_ratio : "+arr.get(i).fail_ratio);
        }
        Collections.sort(arr,(stage1,stage2)->{
            if(Double.compare(stage2.fail_ratio,stage1.fail_ratio)==0){
                return stage1.stage_level-stage2.stage_level;
            }
            return  Double.compare(stage2.fail_ratio,stage1.fail_ratio);
        });
        
        for(int i = 0 ; i<arr.size();i++){
            
            answer[i]=arr.get(i).stage_level;    
        }
        
        return answer;
    }
}
class Stages{
    public int stage_level=0;
    public int inStage_user=0;
    public int allStage_user=0;
    public double fail_ratio = 0;
    
    public Stages(int stage_level){
        this.stage_level = stage_level;
    }
    
}