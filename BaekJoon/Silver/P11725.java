import java.io.*;
import java.util.*;

public class P11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vertexNumber = Integer.parseInt(br.readLine());

        List<List<Integer>> collection = new ArrayList<>();

        for(int i = 0; i <= vertexNumber; i++) {
            collection.add(new ArrayList<>());
        }

        for(int i = 0; i < vertexNumber - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            collection.get(start).add(end);
            collection.get(end).add(start);
        }

        int[] parent = new int[vertexNumber + 1];
        Arrays.fill(parent, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        parent[1] = 0;
        while(!q.isEmpty()) {
            int currentVertex = q.poll();

            for(int i = 0; i < collection.get(currentVertex).size(); i++) {
                int nextVertex = collection.get(currentVertex).get(i);
                if(parent[nextVertex] == -1) {
                    parent[nextVertex] = currentVertex;
                    q.add(nextVertex);
                }
            }
        }

        for(int i = 2; i <= vertexNumber; i++) {
            System.out.println(parent[i]);
        }
    }
}
