import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int[][] arr = new int[n][n];
        
        // //첫번째 배열
        for(int i = 0 ; i < arr1.length;i++){
            String binary_str="";
            while(arr1[i]!=0){
                binary_str+=(arr1[i]%2)+"";
                arr1[i]/=2;
            }
            int k =0 ;
            int l =n-1 ;
            for(int j = 0; j < binary_str.length();j++){
                arr[i][l]=binary_str.charAt(k)-'0';
                k++;
                l--;
            }
        }

        //두번째 배열
        for(int i = 0 ; i < arr2.length;i++){
            String binary_str="";
            while(arr2[i]!=0){
                binary_str+=(arr2[i]%2)+"";
                arr2[i]/=2;
            }
            int k =0 ;
            int l =n-1 ;
            for(int j = 0; j < binary_str.length();j++){
                if(arr[i][l]==1){
                    l--;
                    k++;
                    continue;
                    
                }
                arr[i][l]=binary_str.charAt(k)-'0';
                k++;
                l--;
            }
        }
        
        int j=0;
        for(int [] list : arr){
            String row="";
            for(int i=0 ; i< list.length;i++){
                if(list[i]==1){
                    row+="#";
                }
                else{
                    row+=" ";
                }
            }
            //System.out.println(row);
            answer[j]=row;
            j++;
        }
        return answer;
    }

}