import java.io.*;

public class P1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcaseNumber = Integer.parseInt(br.readLine());

        long[][] dp = new long[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i -2 ][1];
        }

        for(int i = 0; i < testcaseNumber; i++) {
            int targetValue = Integer.parseInt(br.readLine());

            System.out.println(dp[targetValue][0] + " " + dp[targetValue][1]);
        }
    }
}
