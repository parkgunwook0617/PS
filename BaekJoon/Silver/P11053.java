import java.io.*;
import java.util.*;

public class P11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] element = new int[count];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < count; i++) {
            element[i] = Integer.parseInt(st.nextToken());
        }

        int[] originalElement = element.clone();

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < count; i++) {
            set.add(element[i]);
        }

        int[] contractElement = new int[set.size()];
        Iterator<Integer> iterSet = set.iterator();

        for(int i = 0; i < set.size(); i++) {
            contractElement[i] = iterSet.next();
        }

        Arrays.sort(contractElement);

        int[][] dp = new int[set.size()][count];

        for(int x = 0; x < set.size(); x++) {
            if(contractElement[x] == originalElement[0]) {
                dp[x][0] = 1;
            }
        }

        for(int x = 1; x < set.size(); x++) {
            if(dp[x-1][0] > dp[x][0]) {
                dp[x][0] = dp[x-1][0];
            }
        }

        for(int y = 0; y < count; y++) {
            if(originalElement[y] == contractElement[0]) {
                dp[0][y] = 1;
            }
        }

        for(int y = 1; y < count; y++) {
            if(dp[0][y-1] > dp[0][y]) {
                dp[0][y] = dp[0][y-1];
            }
        }

        for(int x = 1; x < set.size(); x++) {
            for(int y = 1; y < count; y++) {
                if(contractElement[x] == originalElement[y]) {
                    dp[x][y] = dp[x-1][y-1] + 1;
                } else if (dp[x-1][y] >= dp[x][y-1]) {
                    dp[x][y] = dp[x-1][y];
                } else {
                    dp[x][y] = dp[x][y-1];
                }
            }
        }

        System.out.println(dp[set.size() - 1][count - 1]);
    }
}
