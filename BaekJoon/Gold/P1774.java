import java.io.*;
import java.util.*;

public class P1774 {
    public static class Edge implements Comparable<Edge> {
        int from;
        int to;
        double weight;

        Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    public static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int already = Integer.parseInt(st.nextToken());
        list = new int[number + 1];
        Arrays.fill(list, -1);
        double[][] numberList = new double[number][2];
        for(int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            double xPos = Double.parseDouble(st.nextToken());
            double yPos = Double.parseDouble(st.nextToken());

            numberList[i][0] = xPos;
            numberList[i][1] = yPos;
        }

        List<Edge> collection = new ArrayList<>();
        for(int x = 0; x < number; x++) {
            for(int y = x + 1; y < number; y++) {
                double distance = Math.sqrt(Math.pow(numberList[x][0] - numberList[y][0], 2) + Math.pow(numberList[x][1] - numberList[y][1], 2));
                collection.add(new Edge(x, y, distance));
            }
        }

        for(int i = 0; i < already; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            union(from - 1, to - 1);
        }

        collection.sort(Comparator.naturalOrder());
        double cost = 0;
        for(int i = 0; i < collection.size(); i++) {
            Edge data = collection.get(i);

            if(union(data.from, data.to)) {
                cost += data.weight;
            }
        }

        System.out.printf("%.2f\n", cost);
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
