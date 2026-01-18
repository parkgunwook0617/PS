import java.io.*;
import java.util.*;

public class P16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ladderCount = Integer.parseInt(st.nextToken());
        int snakeCount = Integer.parseInt(st.nextToken());

        List<List<Integer>> collection = new ArrayList<>();

        for(int i = 0; i <= 100; i++) {
            collection.add(new ArrayList<>());
        }

        for(int i = 0; i < ladderCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            collection.get(start).add(end);
        }

        for(int i = 0; i < snakeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            collection.get(start).add(end);
        }

        for(int i = 0; i <= 100; i++) {
            if(collection.get(i).size() != 1) {
                for(int k = 1; k <= 6; k++) {
                    collection.get(i).add(i + k);
                }
            }
        }

        int[] visited = new int[101];
        Arrays.fill(visited, -1);
        visited[1] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while(!q.isEmpty()) {
            int position = q.poll();

            for(int i = 0; i < collection.get(position).size(); i++) {
                int nextValue = collection.get(position).get(i);

                if(nextValue <= 100) {
                    if(collection.get(nextValue).size() == 1) {
                        nextValue = collection.get(nextValue).get(0);
                    }

                    if(visited[nextValue] == -1) {
                        visited[nextValue] = visited[position] + 1;
                        q.add(nextValue);
                    }
                }
            }
        }

        System.out.println(visited[100]);
    }
}
