import java.io.*;
import java.util.*;

public class P9372 {
    public static int[] list;
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseNumber = Integer.parseInt(br.readLine());
        while(testcaseNumber != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cityNumber = Integer.parseInt(st.nextToken());
            int lineNumber = Integer.parseInt(st.nextToken());
            list = new int[cityNumber + 1];
            Arrays.fill(list, -1);

            for(int i = 0; i < lineNumber; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                if(union(from, to)) {
                    count++;
                }
            }

            System.out.println(count);

            count = 0;

            testcaseNumber--;
        }
    }

    public static int find(int i) {
        if(list[i] < 0) {
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
