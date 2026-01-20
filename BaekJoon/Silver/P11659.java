import java.io.*;
import java.util.*;

public class P11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] numberTable = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            numberTable[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[n];
        dp[0] = numberTable[0];

        for(int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + numberTable[i];
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            if(start >= 1) {
                System.out.println(dp[end] - dp[start - 1]);
            } else {
                System.out.println(dp[end]);
            }
        }
    }
}
