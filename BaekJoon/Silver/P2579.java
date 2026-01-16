import java.io.*;

public class P2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stairCount =  Integer.parseInt(br.readLine());
        int[] stairScore = new int[stairCount];
        int[][] dp = new int[stairCount][2];

        for(int i = 0; i < stairCount; i++) {
            stairScore[i] = Integer.parseInt(br.readLine());
        }

        if(stairCount == 1) {
            System.out.println(stairScore[0]);
            System.exit(0);
        }

        dp[0][0] = stairScore[0];
        dp[1][0] = stairScore[1];
        dp[1][1] = stairScore[0] + stairScore[1];
        for(int x = 2; x < stairCount; x++) {
            dp[x][0] = Math.max(dp[x-2][0], dp[x-2][1]) + stairScore[x];
            dp[x][1] = dp[x-1][0] + stairScore[x];
        }

        System.out.println(Math.max(dp[stairCount - 1][0], dp[stairCount - 1][1]));
    }
}
