import java.io.*;

public class P2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int wineCount = Integer.parseInt(br.readLine());
        int[] wineData = new int[wineCount];

        for(int i = 0; i < wineCount; i++) {
            wineData[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[wineCount];
        dp[0] = wineData[0];
        if(wineCount == 1) {
            System.out.println(dp[0]);
            System.exit(0);
        }
        dp[1] = wineData[0] + wineData[1];
        if(wineCount == 2) {
            System.out.println(dp[1]);
            System.exit(0);
        }
        dp[2] = Math.max(wineData[2] + dp[0], Math.max(wineData[2] + wineData[1], dp[1]));

        for(int i = 3; i < wineCount; i++) {
            dp[i] = Math.max(wineData[i] + dp[i - 2], Math.max(wineData[i] + wineData[i -1] + dp[i - 3], dp[i - 1]));
        }

        System.out.println(dp[wineCount - 1]);
    }
}
