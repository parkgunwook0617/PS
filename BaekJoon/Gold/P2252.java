import java.io.*;
import java.util.*;

public class P2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int person = Integer.parseInt(st.nextToken());
        int tryNumber = Integer.parseInt(st.nextToken());

        List<List<Integer>> collection = new ArrayList<>();
        int[] indegree = new int[person + 1];

        for(int i = 0; i <= person; i++) {
            collection.add(new ArrayList<>());
        }

        for(int i = 0; i < tryNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            collection.get(from).add(to);
            indegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= person; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()) {
            int current = q.poll();
            sb.append(current).append(" ");

            for(int i = 0; i < collection.get(current).size(); i++) {
                int linked = collection.get(current).get(i);

                indegree[linked]--;

                if(indegree[linked] == 0) {
                    q.add(linked);
                }
            }
        }

        System.out.println(sb);
    }
}
