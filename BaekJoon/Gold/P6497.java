import java.io.*;
import java.util.*;

public class P6497 {
    public static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int houseNumber = Integer.parseInt(st.nextToken());
        int lineNumber = Integer.parseInt(st.nextToken());
        while(!(houseNumber == 0 && lineNumber == 0)) {
            int totalWeight = 0;
            int[][] collection = new int[lineNumber][3];
            list = new int[houseNumber];
            Arrays.fill(list, -1);

            for(int i = 0; i < lineNumber; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                collection[i][0] = from;
                collection[i][1] = to;
                collection[i][2] = weight;

                totalWeight += weight;
            }

            Arrays.sort(collection, (o1, o2) -> {
                return o1[2] - o2[2];
            });

            int minWeight = 0;
            for(int i = 0; i < lineNumber; i++) {
                if(union(collection[i][0], collection[i][1])) {
                    minWeight += collection[i][2];
                }
            }

            System.out.println(totalWeight - minWeight);

            st = new StringTokenizer(br.readLine());
            houseNumber = Integer.parseInt(st.nextToken());
            lineNumber = Integer.parseInt(st.nextToken());
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
