import java.io.*;

public class P1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        long[] dp = new long[length + 2];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i < length + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        System.out.println(dp[length] % 15746);
    }
}
