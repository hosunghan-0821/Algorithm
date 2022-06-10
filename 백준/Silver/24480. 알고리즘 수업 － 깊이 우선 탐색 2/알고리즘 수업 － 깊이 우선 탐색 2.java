import java.util.*;
import java.io.*;

public class Main {
    static int[] answer ; 
    static ArrayList<Integer> [] edges;
    static int idx= 0 ;
    static boolean[] v;
    
    public static void dfs(int cur){
        answer[cur]= ++idx;
        for(int next : edges[cur]){
            if(v[next]){
                continue;
            }
            v[next]=true;
            dfs(next);
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer (br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
      
       
        edges = new ArrayList[N+1];
        for(int i =1 ; i <=N ; i++){
            edges[i] = new ArrayList<>();
        }
        answer = new int[N+1];
        v = new boolean [N+1];
        
         while( M-->0 ){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
             edges[u].add(v);
             edges[v].add(u);
        }
        
        for ( int i=1 ; i<=N ; i++){
            Collections.sort(edges[i],Collections.reverseOrder());
        }
        v[R]=true;
        dfs(R);
        
        StringBuilder sb =new StringBuilder();
        for(int i = 1 ; i<=N;i++){
            sb.append(answer[i]).append('\n');
        }
        System.out.println(sb);
    }
}

