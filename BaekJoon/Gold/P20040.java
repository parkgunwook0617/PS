import java.io.*;
import java.util.*;

public class P20040 {
    public static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dotNumber = Integer.parseInt(st.nextToken());
        int lineNumber = Integer.parseInt(st.nextToken());
        int step = 0;
        boolean isLinked = false;
        list = new int[dotNumber];
        Arrays.fill(list, -1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < lineNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            step++;

            if(!union(from, to)) {
                isLinked = true;
                break;
            }
        }
        if(isLinked) {
            sb.append(step);
            System.out.println(sb);
        } else {
            System.out.println(0);
        }
    }

    public static int find(int i) {
        if (list[i] < 0) {
            return i;
        }

        return list[i] = find(list[i]);
    }

    public static boolean union(int v, int u) {
        v = find(v);
        u = find(u);

        if(v == u) {
            return false;
        }

        list[v] = u;
        return true;
    }
}
