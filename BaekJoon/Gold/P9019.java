import java.io.*;
import java.util.*;

public class P9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseNumber = Integer.parseInt(br.readLine());

        List<List<Integer>> collection = new ArrayList<>();

        for(int i = 0; i <= 9999; i++) {
            collection.add(new ArrayList<>());
        }

        for(int i = 1; i <= 9999; i++) {
            int first = i % 10;
            int second = i % 100 / 10;
            int third = i % 1000 / 100;
            int fourth = i / 1000;

            if(2 * i < 9999) {
                collection.get(i).add(2 * i);
            } else {
                collection.get(i).add(2 * i % 10000);
            }

            collection.get(i).add(i - 1);
            collection.get(i).add(first * 10 + second * 100 + third * 1000 + fourth);
            collection.get(i).add(first * 1000 + second + third * 10 + fourth * 100);
        }
        collection.get(0).add(9999);

        while(testcaseNumber != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            int[] isVisited = new int[10001];
            int[] parent = new int[100001];
            char[] currentOrder = new char[100001];
            String[] path = new String[10001];
            Arrays.fill(isVisited, -1);
            Arrays.fill(path, "");
            q.add(from);
            isVisited[from] = 0;
            while(!q.isEmpty()) {
                int current = q.poll();

                int first = current % 10;
                int second = current % 100 / 10;
                int third = current % 1000 / 100;
                int fourth = current / 1000;

                for(int i = 0; i < collection.get(current).size(); i++) {
                    int next = collection.get(current).get(i);

                    if(isVisited[next] == -1) {
                        q.add(next);
                        if(next == current * 2 || next == current * 2 % 10000) {
                            currentOrder[next] = 'D';
                        } else if (next == current - 1 || (current == 0 && next == 9999)) {
                            currentOrder[next] = 'S';
                        } else if (next == first * 10 + second * 100 + third * 1000 + fourth) {
                            currentOrder[next] = 'L';
                        } else {
                            currentOrder[next] = 'R';
                        }
                        isVisited[next] = isVisited[current] + 1;
                        parent[next] = current;
                    }
                }
            }

            int target = end;
            StringBuilder sb = new StringBuilder();
            while (target != from) {
                sb.append(currentOrder[target]);
                target = parent[target];
            }

            System.out.println(sb.reverse());

            testcaseNumber--;
        }

    }
}
