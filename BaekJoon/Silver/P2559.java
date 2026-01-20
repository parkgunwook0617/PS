import java.io.*;
import java.util.*;

public class P2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] numberTable = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            numberTable[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = numberTable[0];
        for(int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + numberTable[i];
        }

        long max = Long.MIN_VALUE;
        for(int i = k - 1; i < n; i++) {
            if(i >= k) {
                max = Math.max(max, dp[i] - dp[i - k]);
            } else {
                max = Math.max(max, dp[i]);
            }
        }

        System.out.println(max);
    }
}
