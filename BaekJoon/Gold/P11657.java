import java.io.*;
import java.util.*;

public class P11657 {
    public static class Edge {
        int from;
        int to;
        int weight;

        Edge (int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertexNumber = Integer.parseInt(st.nextToken());
        int lineNumber = Integer.parseInt(st.nextToken());

        List<Edge> collection = new ArrayList<>();
        for(int i = 0; i < lineNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            collection.add(new Edge(start, end, weight));
        }
        long[] distance = new long[vertexNumber + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[1] = 0;

        for(int i = 0; i < vertexNumber; i++) {
            for(int k = 0; k < lineNumber; k++) {
                Edge edge = collection.get(k);

                if(distance[edge.from] != Long.MAX_VALUE && distance[edge.to] > distance[edge.from] + edge.weight) {
                    distance[edge.to] = distance[edge.from] + edge.weight;
                }
            }
        }

        for(int i = 0; i < lineNumber; i++) {
            Edge edge = collection.get(i);

            if(distance[edge.from] != Long.MAX_VALUE && distance[edge.to] > distance[edge.from] + edge.weight) {
                System.out.println(-1);
                System.exit(0);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= vertexNumber; i++) {
            if(distance[i] == Long.MAX_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
