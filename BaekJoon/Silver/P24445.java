import java.io.*;
import java.util.*;

public class P24445 {
    public static List<List<Integer>> collection = new ArrayList<>();
    public static int[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertexNumber = Integer.parseInt(st.nextToken());
        int lineNumber = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        isVisited = new int[vertexNumber + 1];

        for(int i = 0; i <= vertexNumber; i++) {
            collection.add(new ArrayList<>());
        }

        for(int i = 0; i < lineNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            collection.get(start).add(end);
            collection.get(end).add(start);
        }

        for(int i = 0; i <= vertexNumber; i++) {
            collection.get(i).sort(Comparator.reverseOrder());
        }

        BFS(startVertex);

        for(int i = 1; i <= vertexNumber; i++) {
            System.out.println(isVisited[i]);
        }
    }

    public static void BFS(int startVertex) {
        Queue<Integer> q = new LinkedList<>();
        int count = 1;

        q.add(startVertex);
        isVisited[startVertex] = count;

        while(!q.isEmpty()) {
            int value = q.poll();
            for(int i = 0; i < collection.get(value).size(); i++) {
                if(isVisited[collection.get(value).get(i)] == 0) {
                    isVisited[collection.get(value).get(i)] = ++count;
                    q.add(collection.get(value).get(i));
                }
            }
        }
    }
}
