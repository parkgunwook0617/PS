import java.io.*;
import java.util.*;

public class P13549 {
    public static class Node implements Comparable<Node> {
        int index;
        int cost;

        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        List<List<Node>> collection = new ArrayList<>();
        for(int i = 0; i <= 100000; i++) {
            collection.add(new ArrayList<>());
        }

        for(int i = 1; i <= 99999; i++) {
            if(i >= 1 && i <= 50000) {
                collection.get(i).add(new Node(i - 1, 1));
                collection.get(i).add(new Node(i + 1, 1));
                collection.get(i).add(new Node(2 * i, 0));
            } else {
                collection.get(i).add(new Node(i - 1, 1));
                collection.get(i).add(new Node(i + 1, 1));
            }
        }

        collection.get(0).add(new Node(1, 1));
        collection.get(100000).add(new Node(99999, 1));

        boolean[] isVisited = new boolean[100001];
        int[] distance = new int[100001];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()) {
            Node position = pq.poll();
            int currentVertex = position.index;

            if(isVisited[currentVertex]) {
                continue;
            }

            isVisited[currentVertex] = true;

            for(int i = 0; i < collection.get(currentVertex).size(); i++) {
                Node nextVertex = collection.get(currentVertex).get(i);

                if(distance[nextVertex.index] > distance[currentVertex] + nextVertex.cost) {
                    distance[nextVertex.index] = distance[currentVertex] + nextVertex.cost;
                    pq.add(new Node(nextVertex.index, distance[nextVertex.index]));
                }
            }
        }

        System.out.println(distance[target]);
    }
}
