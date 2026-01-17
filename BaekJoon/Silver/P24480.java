import java.io.*;
import java.util.*;

public class P24480 {
    public static List<List<Integer>> collection = new ArrayList<>();
    public static int[] isVisited;
    public static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertexNumber = Integer.parseInt(st.nextToken());
        int lineNumber = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= vertexNumber; i++) {
            collection.add(new ArrayList<>());
        }

        isVisited = new int[vertexNumber + 1];

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

        DFS(startVertex);

        for(int i = 1; i <= vertexNumber; i++) {
            System.out.println(isVisited[i]);
        }
    }

    public static void DFS(int startVertex) {
        isVisited[startVertex] = count++;

        for(int i = 0; i < collection.get(startVertex).size(); i++) {
            if(isVisited[collection.get(startVertex).get(i)] == 0) {
                DFS(collection.get(startVertex).get(i));
            }
        }
    }
}
