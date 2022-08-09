import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static int N,K,L;
    public static int[][] map;
    public static Deque<Point> deque = new ArrayDeque <Point>();

    public static int[] dy = {1,0,-1,0};
    public static int[] dx = {0,1,0,-1};

    public  static char[] r = new char[10001];
    public static void main(String[] args) throws IOException{
        int res = 0 ;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // NXN 정사각형
        N= Integer.parseInt(br.readLine());
        // 사과 개수
        K= Integer.parseInt(br.readLine());

        map = new int[N][N];
        deque.add(new Point(0,0));

        for(int i = 0 ; i < K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            map[row-1][col-1]=1;
        }
        //명령어 개수
        L =Integer.parseInt(br.readLine());

        for(int i = 0 ; i < L ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int t = Integer.parseInt(st.nextToken());
            //초에 방향전환정보 넣는거구나.
            //해당하는 초에 방향전환 정보 삽입
            r[t]= st.nextToken().charAt(0);
        }

        int dir=0;
        while(true){
            res++;
            int x = deque.getLast().x + dx[dir];
            int y = deque.getLast().y + dy[dir];

            Point p = new Point(x,y);

            if(y<0 || y>=N || x<0 || x>= N || deque.contains(p)){
                break;
            }

            //머리 한칸 전진
            deque.add(p);
            //사과가 없다면 꼬리 제거
            if(map[x][y]!=1) deque.removeFirst();
            //사과가 있다면 꼬리 유지
            else map[x][y]=0;

            //방향전환관련
            if(r[res]=='D') dir = (dir+1)%4;
            if(r[res]=='L') dir = (dir+3)%4;
        }
        System.out.println(res);
    }
}
