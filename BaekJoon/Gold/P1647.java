import java.io.*;
import java.util.*;

public class P1647 {
    public static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int houseNumber = Integer.parseInt(st.nextToken());
        int lineNumber = Integer.parseInt(st.nextToken());

        list = new int[houseNumber + 1];
        Arrays.fill(list, - 1);

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

        int totalMoney = 0;
        int finalConnectionMoney = 0;
        for(int i = 0; i < lineNumber; i++) {
            int[] nextLine = collection[i];

            if(union(nextLine[0], nextLine[1])) {
                totalMoney += nextLine[2];
                finalConnectionMoney = nextLine[2];
            }
        }

        System.out.println(totalMoney - finalConnectionMoney);
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
