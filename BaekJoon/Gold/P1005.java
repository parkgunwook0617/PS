import java.io.*;
import java.util.*;

public class P1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcaseNumber = Integer.parseInt(br.readLine());

        while(testcaseNumber != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int structureNumber = Integer.parseInt(st.nextToken());
            int orderNumber = Integer.parseInt(st.nextToken());
            List<List<Integer>> collection = new ArrayList<>();


            for(int i = 0; i <= structureNumber; i++) {
                collection.add(new ArrayList<>());
            }

            int[] indegree = new int[structureNumber + 1];
            int[] time = new int[structureNumber + 1];
            st = new StringTokenizer(br.readLine());

            for(int i = 1; i <= structureNumber; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < orderNumber; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                indegree[to]++;
                collection.get(from).add(to);
            }

            int targetStructure = Integer.parseInt(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            int[] resultTime = new int[structureNumber + 1];
            for(int i = 1; i <= structureNumber; i++) {
                resultTime[i] = time[i];
                if(indegree[i] == 0) {
                    q.add(i);
                }
            }

            while(!q.isEmpty()) {
                int next = q.poll();

                if(next == targetStructure) {
                    break;
                }

                for(int i = 0; i < collection.get(next).size(); i++) {
                    int following = collection.get(next).get(i);
                    resultTime[following] = Math.max(resultTime[following], resultTime[next] + time[following]);
                    indegree[following]--;

                    if(indegree[following] == 0) {
                        q.add(following);
                    }
                }
            }

            System.out.println(resultTime[targetStructure]);

            testcaseNumber--;
        }
    }
}
