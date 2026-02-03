import java.io.*;
import java.util.*;

public class P4386 {
    public static class edge implements Comparable<edge> {
        int from;
        int to;
        double weight;

        edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    public static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        double[][] collection = new double[size][2];
        list = new int[size + 1];
        Arrays.fill(list, -1);

        for(int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            double xPos = Double.parseDouble(st.nextToken());
            double yPos = Double.parseDouble(st.nextToken());

            collection[i][0] = xPos;
            collection[i][1] = yPos;
        }

        List<edge> lineList = new ArrayList<>();
        for(int x = 0; x < size; x++) {
            for(int y = x + 1; y < size; y++) {
                double distance = Math.sqrt(Math.pow(collection[x][0] - collection[y][0], 2) + Math.pow(collection[x][1] - collection[y][1], 2));

                lineList.add(new edge(x, y, distance));
            }
        }

        lineList.sort(Comparator.naturalOrder());
        double cost = 0;
        for(int i = 0; i < lineList.size(); i++) {
            edge data = lineList.get(i);

            if(union(data.from, data.to)) {
                cost += data.weight;
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
