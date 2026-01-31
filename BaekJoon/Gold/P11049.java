import java.io.*;
import java.util.*;

public class P11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        long[] list = new long[size + 1];

        for(int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[i] = Long.parseLong(st.nextToken());

            if(i == size - 1) {
                list[i + 1] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[size + 1][size + 1];
        for(int i = 0; i <= size; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
            dp[i][i] = 0;
        }

        for(int y = 1; y <= size; y++) {
            for(int x = size; x > 0; x--) {
                if(x > y) {
                    continue;
                }

                for(int salt = x; salt < y; salt++) {
                    long cost = dp[x][salt] + dp[salt + 1][y] + list[x - 1] * list[salt] * list[y];
                    dp[x][y] = Math.min(dp[x][y], cost);
                }
            }
        }

        System.out.println(dp[1][size]);
    }
}
