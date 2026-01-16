import java.io.*;
import java.util.*;

public class P1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int height = Integer.parseInt(br.readLine());
        int[][] table = new int[height][height];
        int row = 1;
        for(int x = 0; x < height; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int y = 0; y < row; y++) {
                table[x][y] = Integer.parseInt(st.nextToken());
            }

            row++;
        }

        int dpRow = 2;
        int[][] dp = new int[height][height];
        dp[0][0] = table[0][0];
        for(int x = 1; x < height; x++) {
            for(int y  = 0; y < dpRow; y++) {
                if(y == 0) {
                    dp[x][y] = dp[x-1][y] + table[x][y];
                } else {
                    dp[x][y] = Math.max(dp[x-1][y-1], dp[x-1][y]) + table[x][y];
                }
            }

            dpRow++;
        }

        int max = 0;
        for(int i = 0; i < height; i++) {
            max = Math.max(max, dp[height - 1][i]);
        }

        System.out.println(max);
    }
}
