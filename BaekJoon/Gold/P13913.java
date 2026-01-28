import java.io.*;
import java.util.*;

public class P13913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        List<List<Integer>> collection = new ArrayList<>();
        for(int i = 0; i <= 100000; i++) {
            collection.add(new ArrayList<>());
        }

        for(int i = 1; i <= 99999; i++) {
            if(i * 2 <= 100000) {
                collection.get(i).add(i * 2);
            }

            collection.get(i).add(i - 1);
            collection.get(i).add(i + 1);
        }

        collection.get(0).add(1);
        collection.get(100000).add(99999);

        int[] isVisited = new int[100001];
        int[] isVisitedPath = new int[100001];
        Arrays.fill(isVisited, -1);
        isVisited[start] = 0;
        isVisitedPath[start] = start;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            int position = q.poll();

            for(int i = 0; i < collection.get(position).size(); i++) {
                int nextValue = collection.get(position).get(i);

                if(isVisited[nextValue] == -1) {
                    q.add(nextValue);
                    isVisited[nextValue] = isVisited[position] + 1;
                    isVisitedPath[nextValue] = position;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(isVisited[end]).append("\n");
        int count = isVisited[end];
        int nextIndex = end;
        List<Integer> list = new ArrayList<>();
        list.add(end);
        while(count != 0) {
            list.add(isVisitedPath[nextIndex]);
            nextIndex = isVisitedPath[nextIndex];

            count--;
        }

        for(int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
