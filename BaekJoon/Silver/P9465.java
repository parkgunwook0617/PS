import java.io.*;
import java.util.*;

public class P9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcaseNumber = Integer.parseInt(br.readLine());

        while(testcaseNumber != 0) {
            int ySize = Integer.parseInt(br.readLine());
            int[][] stickerTable = new int[2][ySize];

            for(int x = 0; x < 2; x++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int y = 0; y < ySize; y++) {
                    stickerTable[x][y] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][ySize];

            dp[0][0] = stickerTable[0][0];
            dp[1][0] = stickerTable[1][0];

            for(int y = 1; y < ySize; y++) {
                if(y == 1) {
                    dp[0][y] = dp[1][0] + stickerTable[0][1];
                    dp[1][y] = dp[0][0] + stickerTable[1][1];
                    continue;
                }
                dp[0][y] = Math.max(dp[1][y - 1], dp[1][y - 2]) + stickerTable[0][y];
                dp[1][y] = Math.max(dp[0][y - 1], dp[0][y - 2]) + stickerTable[1][y];
            }

            System.out.println(Math.max(dp[0][ySize - 1], dp[1][ySize - 1]));

            testcaseNumber--;
        }
    }
}
