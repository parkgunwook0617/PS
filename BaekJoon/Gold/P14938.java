import java.io.*;
import java.util.*;

public class P14938 {
    public static List<List<Node>> collection = new ArrayList<>();

    public static class Node implements Comparable<Node> {
        int index;
        int weight;

        Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexNumber = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());
        int lineNumber = Integer.parseInt(st.nextToken());

        int[] item = new int[vertexNumber + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= vertexNumber; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i <= vertexNumber; i++) {
            collection.add(new ArrayList<>());
        }

        for(int i = 0; i < lineNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            collection.get(from).add(new Node(to, weight));
            collection.get(to).add(new Node(from, weight));
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= vertexNumber; i++) {
            int[] distance = Dijkstra(i, vertexNumber);

            int itemNumber = 0;
            for(int k = 1; k <= vertexNumber; k++) {
                if(distance[k] <= range) {
                    itemNumber += item[k];
                }
            }

            if(max < itemNumber) {
                max = itemNumber;
            }
        }

        System.out.println(max);
    }

    public static int[] Dijkstra(int startVertex, int vertexNumber) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[vertexNumber + 1];
        int[] distance = new int[vertexNumber + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startVertex] = 0;

        pq.add(new Node(startVertex, 0));
        while(!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currentVertex = currentNode.index;

            if(isVisited[currentVertex]) {
                continue;
            }

            isVisited[currentVertex] = true;

            for(int i = 0; i < collection.get(currentVertex).size(); i++) {
                Node nextNode = collection.get(currentVertex).get(i);

                if(distance[nextNode.index] > distance[currentVertex] + nextNode.weight) {
                    distance[nextNode.index] = distance[currentVertex] + nextNode.weight;

                    pq.add(new Node(nextNode.index, distance[nextNode.index]));
                }
            }
        }

        return distance;
    }
}
