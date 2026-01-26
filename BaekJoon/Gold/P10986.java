import java.io.*;
import java.util.*;

public class P10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] collection = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        collection[1] = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(collection[1] % m, 1);

        for(int i = 2; i <= n; i++) {
            collection[i] = collection[i - 1] + Integer.parseInt(st.nextToken());
            collection[i] = collection[i] % m;
            map.put(collection[i], map.getOrDefault(collection[i], 0) + 1);
        }

        long total = 0;
        for(int i = 1; i < m; i++) {
            total += ((long) map.getOrDefault(i, 0) * (map.getOrDefault(i, 0) - 1)) / 2;
        }

        total += ((long) map.getOrDefault(0, 0) * (map.getOrDefault(0, 0) - 1)) / 2 + map.getOrDefault(0, 0);

        System.out.println(total);
    }
}
