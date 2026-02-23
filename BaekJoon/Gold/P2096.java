import java.io.*;
import java.util.*;

public class P2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[][] table = new int[size][3];
        for(int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
            table[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[size][3];
        int[][] dp2 = new int[size][3];
        dp[0][0] = table[0][0];
        dp[0][1] = table[0][1];
        dp[0][2] = table[0][2];

        for(int i = 1; i < size; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + table[i][0], dp[i - 1][1] + table[i][0]);
            dp[i][1] = Math.max(dp[i - 1][1] + table[i][1], Math.max(dp[i - 1][0] + table[i][1], dp[i - 1][2] + table[i][1]));
            dp[i][2] = Math.max(dp[i - 1][1] + table[i][2], dp[i - 1][2] + table[i][2]);
        }

        dp2[0][0] = table[0][0];
        dp2[0][1] = table[0][1];
        dp2[0][2] = table[0][2];

        for(int i = 1; i < size; i++) {
            dp2[i][0] = Math.min(dp2[i - 1][0] + table[i][0], dp2[i - 1][1] + table[i][0]);
            dp2[i][1] = Math.min(dp2[i - 1][1] + table[i][1], Math.min(dp2[i - 1][0] + table[i][1], dp2[i - 1][2] + table[i][1]));
            dp2[i][2] = Math.min(dp2[i - 1][1] + table[i][2], dp2[i - 1][2] + table[i][2]);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++) {
            max = Math.max(dp[size - 1][i], max);
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            min = Math.min(dp2[size - 1][i], min);
        }

        System.out.println(max + " " + min);
    }
}
