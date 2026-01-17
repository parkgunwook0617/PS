import java.io.*;
import java.util.*;

public class P1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseNumber = Integer.parseInt(br.readLine());

        while(testCaseNumber != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertexNumber = Integer.parseInt(st.nextToken());
            int lineNumber = Integer.parseInt(st.nextToken());

            List<List<Integer>> collection = new ArrayList<>();
            for(int i = 0; i <= vertexNumber; i++) {
                collection.add(new ArrayList<>());
            }

            for(int i = 0; i < lineNumber; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                collection.get(start).add(end);
                collection.get(end).add(start);
            }

            int[] table = new int[vertexNumber + 1];
            Queue<Integer> q = new LinkedList<>();

            for(int k = 1; k <= vertexNumber; k++) {
                if(table[k] == 0) {
                    q.add(k);
                    table[k] = 1;

                    while(!q.isEmpty()) {
                        int position = q.poll();

                        for(int i = 0; i < collection.get(position).size(); i++) {
                            int nextValue = collection.get(position).get(i);

                            if(table[nextValue] == 0) {
                                table[nextValue] = table[position] + 1;
                                q.add(nextValue);
                            }
                        }
                    }
                }
            }

            boolean iseibun = true;
            for(int i = 1; i <= vertexNumber; i++) {
                for(int k = 0; k < collection.get(i).size(); k++) {
                    if(table[i] % 2 == 0) {
                        if(table[collection.get(i).get(k)] % 2 == 0) {
                            iseibun = false;
                            break;
                        }
                    } else if (table[i] % 2 == 1) {
                        if(table[collection.get(i).get(k)] % 2 == 1) {
                            iseibun = false;
                            break;
                        }
                    }
                }

                if(!iseibun) {
                    break;
                }
            }

            if(iseibun) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            testCaseNumber--;
        }
    }
}
