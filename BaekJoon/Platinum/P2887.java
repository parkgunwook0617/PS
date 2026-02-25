import java.io.*;
import java.util.*;

public class P2887 {
    public static class Node implements Comparable<Node> {
        int planet1;
        int planet2;
        int cost;

        Node(int planet1, int planet2, int cost) {
            this.planet1 = planet1;
            this.planet2 = planet2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int planetNumber = Integer.parseInt(br.readLine());

        parent = new int[planetNumber];
        Arrays.fill(parent, -1);

        int[][] planet = new int[planetNumber][4];
        for(int i = 0; i < planetNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            planet[i][0] = Integer.parseInt(st.nextToken());
            planet[i][1] = Integer.parseInt(st.nextToken());
            planet[i][2] = Integer.parseInt(st.nextToken());
            planet[i][3] = i;
        }

        Arrays.sort(planet, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < planetNumber - 1; i++) {
            pq.add(new Node(planet[i][3], planet[i + 1][3], Math.abs(planet[i][0] - planet[i + 1][0])));
        }

        Arrays.sort(planet, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        for(int i = 0; i < planetNumber - 1; i++) {
            pq.add(new Node(planet[i][3], planet[i + 1][3], Math.abs(planet[i][1] - planet[i + 1][1])));
        }

        Arrays.sort(planet, (o1, o2) -> {
            return o1[2] - o2[2];
        });

        for(int i = 0; i < planetNumber - 1; i++) {
            pq.add(new Node(planet[i][3], planet[i + 1][3], Math.abs(planet[i][2] - planet[i + 1][2])));
        }

        int cost = 0;
        while(!pq.isEmpty()) {
            Node currentNode = pq.poll();

            if(union(currentNode.planet1, currentNode.planet2)) {
                cost += currentNode.cost;
            }
        }

        System.out.println(cost);
    }

    public static int find(int v) {
        if(parent[v] < 0) {
            return v;
        }

        return parent[v] = find(parent[v]);
    }

    public static boolean union(int v, int u) {
        v = find(v);
        u = find(u);

        if(v == u) {
            return false;
        }

        parent[v] = u;
        return true;
    }
}
