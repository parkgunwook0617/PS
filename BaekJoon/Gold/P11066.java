import java.io.*;
import java.util.*;

public class P11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseNumber = Integer.parseInt(br.readLine());
        while(testcaseNumber != 0) {
            int size = Integer.parseInt(br.readLine());

            int[] list = new int [size + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= size; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[size + 1][size + 1];
            int[] sum = new int[size + 1];
            sum[1] = list[1];
            for(int i = 2; i <= size; i++) {
                sum[i] = sum[i - 1] + list[i];
            }

            for(int i = 1; i <= size; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
                dp[i][i] = 0;
            }

            for(int y = 1; y <= size; y++) {
                for(int x = size; x > 0; x--) {
                    if(x >= y) {
                        continue;
                    }

                    for(int salt = x; salt < y; salt++) {
                        int cost = dp[x][salt] + dp[salt + 1][y] + sum[y] - sum[x - 1];
                        if(cost < dp[x][y]) {
                            dp[x][y] = cost;
                        }
                    }
                }
            }
            System.out.println(dp[1][size]);
            testcaseNumber--;
        }
    }
}
