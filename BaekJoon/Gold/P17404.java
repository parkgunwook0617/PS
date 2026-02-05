import java.io.*;
import java.util.*;

public class P17404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int houseNumber = Integer.parseInt(br.readLine());
        int[][] houseCollection = new int[houseNumber][3];
        for(int i = 0; i < houseNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            houseCollection[i][0] = Integer.parseInt(st.nextToken());
            houseCollection[i][1] = Integer.parseInt(st.nextToken());
            houseCollection[i][2] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int[][] dp = new int[houseNumber][3];
        for(int k = 0; k < 3; k++) {
            if(k == 0) {
                dp[0][0] = houseCollection[0][0];
                dp[0][1] = 1001;
                dp[0][2] = 1001;
            } else if (k == 1) {
                dp[0][0] = 1001;
                dp[0][1] = houseCollection[0][1];
                dp[0][2] = 1001;
            } else if (k == 2) {
                dp[0][0] = 1001;
                dp[0][1] = 1001;
                dp[0][2] = houseCollection[0][2];
            }

            for(int i = 1; i < houseNumber; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + houseCollection[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + houseCollection[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + houseCollection[i][2];
            }

            if(k == 0) {
                min = Math.min(min, Math.min(dp[houseNumber - 1][1], dp[houseNumber - 1][2]));
            } else if (k == 1) {
                min = Math.min(min, Math.min(dp[houseNumber - 1][0], dp[houseNumber - 1][2]));
            } else if (k == 2) {
                min = Math.min(min, Math.min(dp[houseNumber - 1][0], dp[houseNumber - 1][1]));
            }
        }

        System.out.println(min);
    }
}
