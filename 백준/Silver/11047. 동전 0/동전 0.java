import java.util.*;
import java.io.*;

public class Main{
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> arrayList = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int money = Integer.parseInt(br.readLine());
            if (money <= value) {
                arrayList.add(money);
            }
        }
        //내림차순으로 변경

        Collections.reverse(arrayList);
        int i = 0;
        int count = 0;
        int divider=0;
        while (value >0) {
            
            divider += divide(value, arrayList.get(i));
            count+=divider;
            value -= arrayList.get(i) * divider;
            divider=0;
            i++;
            
        }
        System.out.println(count);
    }

    static int divide(int value, int price) {
        return value / price;
    }


}
