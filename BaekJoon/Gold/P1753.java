import java.io.*;
import java.util.*;

public class P1753 {
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

        int vertexNumber = Integer.parseInt(st.nextToken());
        int lineNumber = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(br.readLine());

        List<List<Node>> collection = new ArrayList<>();

        for(int i = 0; i <= vertexNumber; i++) {
            collection.add(new ArrayList<>());
        }

        for(int i = 0; i < lineNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            collection.get(start).add(new Node(end, weight));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[vertexNumber + 1];
        int[] distance = new int[vertexNumber + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startVertex] = 0;
        pq.add(new Node(startVertex, 0));

        while(!pq.isEmpty()) {
            Node information = pq.poll();
            int currentVertex = information.index;

            if(isVisited[currentVertex]) {
                continue;
            }

            isVisited[currentVertex] = true;

            for(int i = 0; i < collection.get(currentVertex).size(); i++) {
                Node nextNode = collection.get(currentVertex).get(i);

                if(distance[nextNode.index] > distance[currentVertex] + nextNode.cost) {
                    distance[nextNode.index] = distance[currentVertex] + nextNode.cost;
                    pq.add(new Node(nextNode.index, distance[nextNode.index]));
                }
            }
        }

        for(int i = 1; i <= vertexNumber; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }
}
