import java.io.*;
import java.util.*;

public class P4195 {
    public static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseNumber = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(testcaseNumber != 0) {
            int lineNumber = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            int count = 0;
            list = new int[200001];
            Arrays.fill(list, -1);
            for(int i = 0; i < lineNumber; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String person1 = st.nextToken();
                String person2 = st.nextToken();

                if(map.get(person1) == null) {
                    map.put(person1, count++);
                }

                if(map.get(person2) == null) {
                    map.put(person2, count++);
                }

                int min = union(map.get(person1), map.get(person2));

                sb.append(Math.abs(min)).append("\n");
            }
            testcaseNumber--;
        }
        System.out.println(sb);
    }

    public static int find(int i) {
        if(list[i] < 0) {
            return i;
        }

        return list[i] = find(list[i]);
    }

    public static int union(int v, int u) {
        v = find(v);
        u = find(u);

        if(v == u) {
            return list[u];
        }

        list[u] += list[v];
        list[v] = u;
        return list[u];
    }
}
