import java.io.*;
import java.util.*;

public class P1167 {
    public static List<List<int[]>> collection;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertexNumber = Integer.parseInt(br.readLine());

        collection = new ArrayList<>();

        for(int i = 0; i <= vertexNumber; i++) {
            collection.add(new ArrayList<>());
        }

        for(int i = 0; i < vertexNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rootVertex = Integer.parseInt(st.nextToken());

            int value = Integer.parseInt(st.nextToken());
            while(value != -1) {
                int length = Integer.parseInt(st.nextToken());

                collection.get(rootVertex).add(new int[]{value, length});

                value = Integer.parseInt(st.nextToken());
            }
        }
        int[] data = BFS(1, vertexNumber);
        int maxVertex = Integer.MIN_VALUE ;
        int maxValue = Integer.MIN_VALUE;
        for(int i = 1; i <= vertexNumber; i++) {
            if(data[i] > maxValue) {
                maxValue = data[i];
                maxVertex = i;
            }
        }
        int[] finalData = BFS(maxVertex, vertexNumber);
        for(int i = 1; i <= vertexNumber; i++) {
            if(finalData[i] > maxValue) {
                maxValue = finalData[i];
            }
        }

        System.out.println(maxValue);
    }

    public static int[] BFS(int startVertex, int vertexNumber) {
        Queue<int[]> q = new LinkedList<>();
        int[] visited = new int[vertexNumber + 1];
        Arrays.fill(visited, -1);

        q.add(new int[]{startVertex, 0});
        visited[startVertex] = 0;

        while(!q.isEmpty()) {
            int[] information = q.poll();

            for(int k = 0; k < collection.get(information[0]).size(); k++) {
                if(visited[collection.get(information[0]).get(k)[0]] == -1) {
                    visited[collection.get(information[0]).get(k)[0]] = visited[information[0]] + collection.get(information[0]).get(k)[1];
                    q.add(new int[]{collection.get(information[0]).get(k)[0], visited[collection.get(information[0]).get(k)[0]]});
                }
            }
        }

        return visited;
    }
}
