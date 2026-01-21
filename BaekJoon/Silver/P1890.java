import java.io.*;
import java.util.*;

public class P1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[][] table = new int[size][size];
        for(int x = 0; x < size; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int y = 0; y < size; y++) {
                table[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[size][size];
        dp[0][0] = 1;
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                if(table[x][y] == 0) {
                    continue;
                }

                if(x + table[x][y] < size) {
                    dp[x + table[x][y]][y] += dp[x][y];
                }

                if(y + table[x][y] < size) {
                    dp[x][y + table[x][y]] += dp[x][y];
                }
            }
        }

        System.out.println(dp[size - 1][size - 1]);
    }
}
