import java.io.*;
import java.util.*;

public class P15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int days = Integer.parseInt(br.readLine());
        int[] ti = new int[days + 1];
        int[] pi = new int[days + 1];
        for(int i = 1; i <= days; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ti[i] = Integer.parseInt(st.nextToken());
            pi[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[days + 2];
        for(int i = 1; i <= days; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);

            int nextDay = i + ti[i];

            if(nextDay > days + 1) {
                continue;
            }

            dp[nextDay] = Math.max(dp[nextDay], dp[i] + pi[i]);
        }

        System.out.println(Math.max(dp[days + 1], dp[days]));
    }
}
