import java.io.*;

public class P10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());

        long[][] dp = new long[10][length];
        for(int i = 0; i < 10; i++) {
            dp[i][0] = 1;
        }

        dp[0][0] = 0;

        for(int x = 1; x < length; x++) {
            for(int y = 0; y < 10; y++) {
                if(y == 0) {
                    dp[y][x] = dp[y + 1][x - 1] % 1000000000;
                } else if (y == 9) {
                    dp[y][x] = dp[y - 1][x - 1] % 1000000000;
                } else {
                    dp[y][x] = (dp[y - 1][x - 1] + dp[y + 1][x - 1]) % 1000000000;
                }
            }
        }

        if(length == 1) {
            System.out.println(9);
        } else {
            long sum = 0;
            for(int x = 0; x < 10; x++) {
                if(x == 0) {
                    sum += dp[x][length - 2];
                } else if (x == 9) {
                    sum += dp[x][length - 2];
                } else {
                    sum += 2 * dp[x][length - 2];
                }
            }
            System.out.println(sum % 1000000000);
        }
    }
}
