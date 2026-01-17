import java.io.*;
import java.util.*;

public class P2606 {
    public static List<List<Integer>> collection = new ArrayList<>();
    public static int count = -1;
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computerNumber = Integer.parseInt(br.readLine());
        int lineNumber = Integer.parseInt(br.readLine());

        for(int i = 0; i <= computerNumber; i++) {
            collection.add(new ArrayList<>());
        }

        isVisited = new boolean[computerNumber + 1];

        for(int i = 0; i < lineNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            collection.get(start).add(end);
            collection.get(end).add(start);
        }

        DFS(1);

        System.out.println(count);
    }

    public static void DFS(int startVertex) {
        isVisited[startVertex] = true;

        count++;

        for(int i = 0; i < collection.get(startVertex).size(); i++) {
            if(!isVisited[collection.get(startVertex).get(i)]) {
                DFS(collection.get(startVertex).get(i));
            }
        }
    }
}
