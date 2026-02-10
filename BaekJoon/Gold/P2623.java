import java.io.*;
import java.util.*;

public class P2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int singerNumber = Integer.parseInt(st.nextToken());
        int lineNumber = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= singerNumber; i++) {
            list.add(new ArrayList<>());
        }

        int[] indegree = new int[singerNumber + 1];

        for(int i = 0; i < lineNumber; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            int front = 0;
            while (st.hasMoreTokens()) {
                if(front == 0) {
                    front = Integer.parseInt(st.nextToken());
                } else {
                    int current = Integer.parseInt(st.nextToken());
                    list.get(front).add(current);
                    indegree[current]++;
                    front = current;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= singerNumber; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
            int current = q.poll();
            result.add(current);

            for(int i = 0; i < list.get(current).size(); i++) {
                int next = list.get(current).get(i);

                indegree[next]--;
                if(indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        if (result.size() != singerNumber) {
            System.out.println(0);
        } else {
            StringBuilder sb = new StringBuilder();

            for (int s : result) {
                sb.append(s).append("\n");
            }

            System.out.print(sb);
        }
    }
}
