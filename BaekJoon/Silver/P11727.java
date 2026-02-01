import java.io.*;

public class P11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] dp = new int[2 * size + 1];
        dp[1] = 1;
        dp[2] = 3;
        for(int i = 3; i  <= 2 * size; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }

        System.out.println(dp[size] % 10007);
    }
}
