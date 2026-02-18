import java.io.*;
import java.util.*;

public class P1865 {
    public static class Line {
        int from;
        int to;
        int weight;

        Line(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseNumber = Integer.parseInt(br.readLine());
        while(testcaseNumber != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int vertexNumber = Integer.parseInt(st.nextToken());
            int roadNumber = Integer.parseInt(st.nextToken());
            int wormholeNumber = Integer.parseInt(st.nextToken());

            List<Line> collection = new ArrayList<>();

            for(int i = 0; i < roadNumber; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                collection.add(new Line(from, to, weight));
                collection.add(new Line(to, from, weight));
            }

            for(int i = 0; i < wormholeNumber; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = -Integer.parseInt(st.nextToken());

                collection.add(new Line(from, to, weight));
            }

            int[] distance = new int[vertexNumber + 1];
            Arrays.fill(distance, 100000);
            boolean possible = false;
            for (int i = 1; i <= vertexNumber; i++) {
                for (Line edge : collection) {
                    if (distance[edge.to] > distance[edge.from] + edge.weight) {
                        distance[edge.to] = distance[edge.from] + edge.weight;

                        if (i == vertexNumber) {
                            possible = true;
                            break;
                        }
                    }
                }

                if(possible) {
                    break;
                }
            }

            if(possible) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            testcaseNumber--;
        }
    }
}
