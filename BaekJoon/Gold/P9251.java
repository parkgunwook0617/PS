import java.io.*;

public class P9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence1 = br.readLine();
        String sentence2 = br.readLine();
        int[][] dp = new int[sentence1.length()][sentence2.length()];

        for(int x = 0; x < sentence1.length(); x++) {
            if(sentence1.charAt(x) == sentence2.charAt(0)) {
                dp[x][0] = 1;
            }
        }

        for(int y = 0; y < sentence2.length(); y++) {
            if(sentence2.charAt(y) == sentence1.charAt(0)) {
                dp[0][y] = 1;
            }
        }

        for(int i = 1; i < sentence1.length(); i++) {
            if(dp[i][0] < dp[i-1][0]) {
                dp[i][0] = dp[i-1][0];
            }
        }

        for(int i = 1; i < sentence2.length(); i++) {
            if(dp[0][i] < dp[0][i-1]) {
                dp[0][i] = dp[0][i-1];
            }
        }

        for(int x = 1; x < sentence1.length(); x++) {
            for(int y = 1; y < sentence2.length(); y++) {
                if(sentence1.charAt(x) == sentence2.charAt(y)) {
                    dp[x][y] = dp[x-1][y-1] + 1;
                } else if (dp[x-1][y] >= dp[x][y-1]) {
                    dp[x][y] = dp[x-1][y];
                } else {
                    dp[x][y] = dp[x][y-1];
                }
            }
        }

        System.out.println(dp[sentence1.length() - 1][sentence2.length() - 1]);
    }
}
