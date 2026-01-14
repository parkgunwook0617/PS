import java.io.*;
import java.util.*;

public class P12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] thing = new int[n + 1][2];
        int[][] dp = new int[n + 1][k + 1];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            thing[i + 1][0] = Integer.parseInt(st.nextToken());
            thing[i + 1][1] = Integer.parseInt(st.nextToken());
        }

        for(int x = 1; x <= n; x++) {
            for(int y = 1; y <= k; y++) {
                if(thing[x][0] <= y) {
                    dp[x][y] = Math.max(dp[x-1][y], dp[x-1][y - thing[x][0]] + thing[x][1]);
                } else {
                    dp[x][y] = dp[x-1][y];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
