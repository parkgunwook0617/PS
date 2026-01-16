import java.io.*;
import java.util.*;

public class P1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int houseNumber = Integer.parseInt(br.readLine());
        int[][] payPerColor = new int[houseNumber][3];
        int[][] dp = new int[houseNumber][3];

        for(int i = 0; i < houseNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            payPerColor[i][0] = Integer.parseInt(st.nextToken());
            payPerColor[i][1] = Integer.parseInt(st.nextToken());
            payPerColor[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = payPerColor[0][0];
        dp[0][1] = payPerColor[0][1];
        dp[0][2] = payPerColor[0][2];

        for(int x = 1; x < houseNumber; x++) {
            for(int y = 0; y < 3; y++) {
                if(y == 0) {
                    dp[x][y] = Math.min(dp[x-1][1] + payPerColor[x][y], dp[x-1][2] + payPerColor[x][y]);
                } else if (y == 1) {
                    dp[x][y] = Math.min(dp[x-1][0] + payPerColor[x][y], dp[x-1][2] + payPerColor[x][y]);
                } else {
                    dp[x][y] = Math.min(dp[x-1][0] + payPerColor[x][y], dp[x-1][1] + payPerColor[x][y]);
                }
            }
        }


        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            min = Math.min(min, dp[houseNumber - 1][i]);
        }

        System.out.println(min);
    }
}
