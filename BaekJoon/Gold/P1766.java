import java.io.*;
import java.util.*;

public class P1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int problemNumber = Integer.parseInt(st.nextToken());
        int informationNumber = Integer.parseInt(st.nextToken());

        List<List<Integer>> collection = new ArrayList<>();

        for(int i = 0; i <= problemNumber; i++) {
            collection.add(new ArrayList<>());
        }

        int[] indegree = new int[problemNumber + 1];

        for(int i = 0; i < informationNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            collection.get(from).add(to);
            indegree[to]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= problemNumber; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int current = q.poll();
            sb.append(current).append(" ");

            for(int i = 0; i < collection.get(current).size(); i++) {
                int next = collection.get(current).get(i);
                indegree[next]--;

                if(indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}
