import java.io.*;
import java.util.*;

public class P1967 {
    public static List<List<int[]>> collection = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertexNumber = Integer.parseInt(br.readLine());

        for(int i = 0; i <= vertexNumber; i++) {
            collection.add(new ArrayList<>());
        }

        for(int i = 0; i < vertexNumber - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            collection.get(start).add(new int[]{end, weight});
            collection.get(end).add(new int[]{start, weight});
        }

        int[] bfsForFind = BFS(1, vertexNumber);
        int max = Integer.MIN_VALUE;
        int maxVertex = 0;
        for(int i = 1; i <= vertexNumber; i++) {
            if(bfsForFind[i] > max) {
                max = bfsForFind[i];
                maxVertex = i;
            }
        }

        int[] finalBFS = BFS(maxVertex, vertexNumber);
        int maxLength = Integer.MIN_VALUE;
        for(int i = 1; i <= vertexNumber; i++) {
            if(finalBFS[i] > maxLength) {
                maxLength = finalBFS[i];
            }
        }

        System.out.println(maxLength);
    }

    public static int[] BFS(int startVertex, int vertexNumber) {
        int[] distance = new int[vertexNumber + 1];
        Arrays.fill(distance, -1);
        distance[startVertex] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startVertex, 0});

        while(!q.isEmpty()) {
            int[] data = q.poll();
            int currentVertex = data[0];

            for(int i = 0; i < collection.get(currentVertex).size(); i++) {
                int[] nextVertex = collection.get(currentVertex).get(i);
                if(distance[nextVertex[0]] == -1) {
                    distance[nextVertex[0]] = distance[currentVertex] + nextVertex[1];
                    q.add(new int[]{nextVertex[0], distance[nextVertex[0]]});
                }
            }
        }

        return distance;
    }
}
