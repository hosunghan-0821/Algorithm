import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
       
       
        ArrayList<data> arr = new ArrayList<>();
        for(int i = 0 ; i <strings.length; i++ ){
            char sort_str =strings[i].charAt(n);
            data data = new data(i,sort_str,strings[i]);
            arr.add(data);
        }
        Comparator<data> comparator = new Comparator<data>(){
            @Override
            public int compare(data a, data b){
                if(a.sort_str-b.sort_str == 0 ){
                    return a.sorting_str.compareTo(b.sorting_str);
                }
                else{
                    return a.sort_str-b.sort_str;    
                }
                
            }
        };
        Collections.sort(arr,comparator);
        
        String[] answer= new String[arr.size()];
        
        for(int i = 0 ; i<arr.size();i++){
            answer[i]=arr.get(i).sorting_str;    
            //System.out.println(arr.get(i).index);
        }
        
        return answer;
    }
}
class data{
        public int index;
        public char sort_str;
        public String sorting_str;
        public data(int index , char sort_str,String sorting_str){
            this.sorting_str = sorting_str;
            this.index = index;
            this.sort_str = sort_str;
    }
}
