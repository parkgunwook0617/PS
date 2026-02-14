import java.io.*;
import java.util.*;

public class P2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int coinNumber = Integer.parseInt(st.nextToken());
        int targetMoney = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < coinNumber; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        List<Integer> collection = new ArrayList<>(set);
        collection.sort(Comparator.naturalOrder());

        int[] dp = new int[targetMoney + 1];
        Arrays.fill(dp, targetMoney + 1);
        for(int i = 0; i < collection.size(); i++) {
            if (collection.get(i) <= targetMoney) {
                dp[collection.get(i)] = 1;
            }
        }

        for(int i = collection.get(0); i <= targetMoney; i++) {
            for(int k = 0; k < collection.size(); k++) {
                if(i - collection.get(k) < 0) {
                    continue;
                }

                dp[i] = Math.min(dp[i], dp[i - collection.get(k)] + 1);
            }
        }

        if(dp[targetMoney] == targetMoney + 1) {
            System.out.println(-1);
        } else {
            System.out.println(dp[targetMoney]);
        }
    }
}
