import java.io.*;
import java.util.*;

public class P4883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseNumber = 1;
        while(true) {
            int xSize = Integer.parseInt(br.readLine());

            if(xSize == 0) {
                System.exit(0);
            }

            int[][] table = new int[xSize][3];
            for(int i = 0; i < xSize; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                table[i][0] = Integer.parseInt(st.nextToken());
                table[i][1] = Integer.parseInt(st.nextToken());
                table[i][2] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[xSize][3];
            dp[0][0] = 10000;
            dp[0][1] = table[0][1];
            dp[0][2] = table[0][1] + table[0][2];

            for(int x = 1; x < xSize; x++) {
                for(int y = 0; y < 3; y++) {
                    if(y == 0) {
                        dp[x][y] = Math.min(dp[x - 1][y] + table[x][y], dp[x - 1][y + 1] + table[x][y]);
                        continue;
                    }

                    if(y == 1) {
                        dp[x][y] = Math.min(dp[x - 1][y - 1] + table[x][y], Math.min(dp[x - 1][y] + table[x][y], dp[x - 1][y + 1] + table[x][y]));
                        continue;
                    }

                    if(y == 2) {
                        dp[x][y] = Math.min(dp[x - 1][y] + table[x][y], dp[x - 1][y - 1] + table[x][y]);
                    }
                }

                dp[x][1] = Math.min(dp[x][1], dp[x][0] + table[x][1]);
                dp[x][2] = Math.min(dp[x][2], dp[x][1] + table[x][2]);
            }

            System.out.println(testcaseNumber + ". " + dp[xSize - 1][1]);
            testcaseNumber++;
        }
    }
}
