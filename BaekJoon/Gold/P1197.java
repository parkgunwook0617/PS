import java.io.*;
import java.util.*;

public class P1197 {
    public static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexNumber = Integer.parseInt(st.nextToken());
        int lineNumber = Integer.parseInt(st.nextToken());
        list = new int[vertexNumber + 1];
        Arrays.fill(list, -1);

        int cost = 0;
        int[][] collection = new int[lineNumber][3];
        for(int i = 0; i < lineNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            collection[i][0] = from;
            collection[i][1] = to;
            collection[i][2] = weight;
        }

        Arrays.sort(collection, (o1, o2) -> {
            return o1[2] - o2[2];
        });

        for(int i = 0; i < lineNumber; i++) {
            if(union(collection[i][0], collection[i][1])) {
                cost+= collection[i][2];
            }
        }

        System.out.println(cost);
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
