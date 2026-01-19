import java.io.*;
import java.util.*;

public class P1956 {
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

    public static List<List<Node>> collection = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertexNumber = Integer.parseInt(st.nextToken());
        int lineNumber = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= vertexNumber; i++) {
            collection.add(new ArrayList<>());
        }

        for(int i = 0; i < lineNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            collection.get(start).add(new Node(end, cost));
        }

        int minLength = Integer.MAX_VALUE;
        int[][] distTable = new int[vertexNumber + 1][];

        for(int i = 1; i <= vertexNumber; i++) {
            distTable[i] = Dijkstra(i, vertexNumber);
        }

        for(int i = 1; i <= vertexNumber; i++) {
            for(int k = 1; k <= vertexNumber; k++) {
                if(i == k) {
                    continue;
                }

                if(distTable[i][k] != Integer.MAX_VALUE && distTable[k][i] != Integer.MAX_VALUE) {
                    minLength = Math.min(minLength, distTable[i][k] + distTable[k][i]);
                }
            }
        }

        if(minLength == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minLength);
        }
    }

    public static int[] Dijkstra(int startVertex, int vertexNumber) {
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
                Node nextVertex = collection.get(currentVertex).get(i);

                if(distance[nextVertex.index] > distance[currentVertex] + nextVertex.cost) {
                    distance[nextVertex.index] = distance[currentVertex] + nextVertex.cost;
                    pq.add(new Node(nextVertex.index, distance[nextVertex.index]));
                }
            }
        }

        return distance;
    }
}
