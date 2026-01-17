import java.io.*;
import java.util.*;

public class P1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startPosition = Integer.parseInt(st.nextToken());
        int endPosition = Integer.parseInt(st.nextToken());

        List<List<Integer>> collection = new ArrayList<>();

        for(int i = 0; i <= 100000; i++) {
            collection.add(new ArrayList<>());
        }

        for(int i = 1; i <= 99999; i++) {
            collection.get(i).add(i - 1);
            collection.get(i).add(i + 1);
            collection.get(i).add(2 * i);
        }

        collection.get(0).add(1);
        collection.get(100000).add(99999);

        Queue<Integer> q = new LinkedList<>();
        int[] isVisited = new int[100001];
        q.add(startPosition);
        isVisited[startPosition] = 1;

        while(!q.isEmpty()) {
            int value = q.poll();

            for(int i = 0; i < collection.get(value).size(); i++) {
                if(collection.get(value).get(i) <= 100000) {
                    if(isVisited[collection.get(value).get(i)] == 0) {
                        isVisited[collection.get(value).get(i)] = isVisited[value] + 1;
                        q.add(collection.get(value).get(i));
                    }
                }
            }
        }

        System.out.println(isVisited[endPosition] - 1);
    }
}
