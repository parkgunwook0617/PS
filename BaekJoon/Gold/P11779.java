import java.io.*;
import java.util.*;

public class P11779 {
    public static class Node implements Comparable<Node>{
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
        int cityNumber = Integer.parseInt(br.readLine());
        int busNumber = Integer.parseInt(br.readLine());

        List<List<Node>> collection = new ArrayList<>();
        for(int i = 0; i <= cityNumber; i++) {
            collection.add(new ArrayList<>());
        }

        for(int i = 0; i < busNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            collection.get(start).add(new Node(end, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        boolean[] isVisited = new boolean[cityNumber + 1];
        int[] distance = new int[cityNumber + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startCity] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startCity, 0));

        int[] parent = new int[cityNumber + 1];

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
                    parent[nextNode.index] = currentVertex;
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int end = endCity;
        int count = 1;
        stack.add(endCity);
        while(end != startCity) {
            stack.add(parent[end]);
            end = parent[end];
            count++;
        }

        while(!stack.empty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(distance[endCity]);
        System.out.println(count);
        System.out.println(sb);
    }
}
