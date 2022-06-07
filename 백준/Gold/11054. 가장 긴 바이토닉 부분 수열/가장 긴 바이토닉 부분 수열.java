import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    static int[] dp, dpR;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        arr = new int[N];
        dp = new int[N];
        dpR = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //Top-Down 재귀 방식 LIS 탐색
        //Top-Down 재귀방식 LDS 탐색
        for (int i = 0; i < N; i++) {
            LIS(i);
            LDS(i);

        }
        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(dp[i] + dpR[i], max);
        }
        System.out.println(max - 1);


    }

    //Top-Down 재귀 방식 LIS 탐색
    static int LIS(int N) {
        //1로 초기화
        if (dp[N] == 0) {
            dp[N] = 1;
        
        for (int i = N - 1; i >= 0; i--) {
            if (arr[N] > arr[i]) {
                dp[N] = Math.max(LIS(i) + 1, dp[N]);
            }
          }
        }
        return dp[N];
    }
    //Top-Down 재귀방식 LDS 탐색

    static int LDS(int N) {
        if (dpR[N] == 0) {
            dpR[N] = 1;
        
            
        for (int i = N + 1; i < dpR.length; i++) {
            if (arr[N] > arr[i]) {
                dpR[N] = Math.max(LDS(i) + 1, dpR[N]);
            }
        }
       }     
        return dpR[N];
    }
 
}