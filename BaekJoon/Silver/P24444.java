import java.io.*;
import java.util.*;

public class P24444 {
    public static int[] isVisited;
    public static List<List<Integer>> collection = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertexNumber = Integer.parseInt(st.nextToken());
        int lineNumber = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());
        isVisited = new int[vertexNumber + 1];

        for(int i = 0; i <= vertexNumber; i++) {
            collection.add(new ArrayList<Integer>());
        }

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

        BFS(startVertex);

        for(int i = 1; i < vertexNumber + 1; i++) {
            System.out.println(isVisited[i]);
        }
    }

    public static void BFS(int startVertex) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(startVertex);

        int count = 1;

        isVisited[startVertex] = count++;

        while(!q.isEmpty()) {
            int value = q.poll();

            for(int i = 0; i < collection.get(value).size(); i++) {
                if(isVisited[collection.get(value).get(i)] == 0) {
                    isVisited[collection.get(value).get(i)] = count++;
                    q.add(collection.get(value).get(i));
                }
            }
        }
    }
}
