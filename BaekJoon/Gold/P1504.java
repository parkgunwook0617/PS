import java.io.*;
import java.util.*;

public class P1504 {
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

    public static List<List<Node>> collection;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertexNumber = Integer.parseInt(st.nextToken());
        int lineNumber = Integer.parseInt(st.nextToken());

        collection = new ArrayList<>();

        for(int i = 0; i <= vertexNumber; i++) {
            collection.add(new ArrayList<>());
        }

        for(int i = 0; i < lineNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            collection.get(start).add(new Node(end, weight));
            collection.get(end).add(new Node(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        int shouldPassVertex1 = Integer.parseInt(st.nextToken());
        int shouldPassVertex2 = Integer.parseInt(st.nextToken());

        int[] fromStart = Dijkstra(1, vertexNumber) ;
        int[] fromPassVertex1 = Dijkstra(shouldPassVertex1, vertexNumber);
        int[] fromPassVertex2 = Dijkstra(shouldPassVertex2, vertexNumber);

        int fail = Integer.MAX_VALUE;
        if(fromStart[shouldPassVertex1] == fail || fromPassVertex1[shouldPassVertex2] == fail || fromPassVertex2[vertexNumber] == fail) {
            if (fromStart[shouldPassVertex2] == fail || fromPassVertex2[shouldPassVertex1] == fail || fromPassVertex1[vertexNumber] == fail) {
                System.out.println(-1);
                System.exit(0);
            }
        }

        int case1 = fromStart[shouldPassVertex1] + fromPassVertex1[shouldPassVertex2] + fromPassVertex2[vertexNumber];
        int case2 = fromStart[shouldPassVertex2] + fromPassVertex2[shouldPassVertex1] + fromPassVertex1[vertexNumber];
        System.out.println(Math.min(case1, case2));
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
                Node nextValue = collection.get(currentVertex).get(i);

                if(distance[nextValue.index] > distance[currentVertex] + nextValue.cost) {
                    distance[nextValue.index] = distance[currentVertex] + nextValue.cost;
                    pq.add(new Node(nextValue.index, distance[nextValue.index]));
                }
            }
        }

        return distance;
    }
}
