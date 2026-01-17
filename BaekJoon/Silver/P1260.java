import java.io.*;
import java.util.*;

public class P1260 {
    public static List<List<Integer>> collection = new ArrayList<>();
    public static boolean[] isVisitedBFS;
    public static boolean[] isVisitedDFS;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertexNumber = Integer.parseInt(st.nextToken());
        int lineNumber = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= vertexNumber; i++) {
            collection.add(new ArrayList<>());
        }

        isVisitedBFS = new boolean[vertexNumber + 1];
        isVisitedDFS = new boolean[vertexNumber + 1];

        for(int i = 0; i < lineNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            collection.get(start).add(end);
            collection.get(end).add(start);
        }

        for(int i = 0; i <= vertexNumber; i++) {
            collection.get(i).sort(Comparator.naturalOrder());
        }

        DFS(startVertex);
        sb.append("\n");
        BFS(startVertex);

        System.out.println(sb);
    }

    public static void DFS(int startVertex) {
        isVisitedDFS[startVertex] = true;
        sb.append(startVertex).append(" ");

        for(int i = 0; i < collection.get(startVertex).size(); i++) {
            if(!isVisitedDFS[collection.get(startVertex).get(i)]) {
                DFS(collection.get(startVertex).get(i));
            }
        }
    }

    public static void BFS(int startVertex) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startVertex);
        isVisitedBFS[startVertex] = true;
        sb.append(startVertex).append(" ");

        while(!q.isEmpty()) {
            int value = q.poll();

            for(int i = 0; i < collection.get(value).size(); i++) {
                if(!isVisitedBFS[collection.get(value).get(i)]) {
                    q.add(collection.get(value).get(i));

                    isVisitedBFS[collection.get(value).get(i)] = true;
                    sb.append(collection.get(value).get(i)).append(" ");
                }
            }
        }
    }
}
