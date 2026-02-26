import java.io.*;
import java.util.*;

public class P2568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lineNumber = Integer.parseInt(br.readLine());

        int[][] line = new int[lineNumber][2];
        for(int i = 0; i < lineNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, (o1, o2) -> {
           return Integer.compare(o1[0], o2[0]);
        });

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < lineNumber; i++) {
            list.add(line[i][1]);
        }

        List<Integer> LIS = new ArrayList<>();
        int[] index = new int[500001];
        Arrays.fill(index, -1);
        LIS.add(list.get(0));
        index[line[0][0]] = 1;

        for(int i = 1; i < lineNumber; i++) {
            int nextValue = list.get(i);
            int currentMax = LIS.get(LIS.size() - 1);

            if(currentMax < nextValue) {
                LIS.add(nextValue);
                index[line[i][0]] = LIS.size();
            } else if (currentMax > nextValue) {
                int idx = Collections.binarySearch(LIS, nextValue);

                if(idx < 0) {
                    idx = -(idx + 1);
                }

                LIS.set(idx, nextValue);
                index[line[i][0]] = idx + 1;
            }
        }

        System.out.println(lineNumber - LIS.size());
        int count = LIS.size();
        boolean[] isLISMember = new boolean[500001];
        for(int i = 500000; i >= 0; i--) {
            if(count == index[i]) {
                isLISMember[i] = true;
                count--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lineNumber; i++) {
            int lineNum = line[i][0];

            if (!isLISMember[lineNum]) {
                sb.append(lineNum).append("\n");
            }
        }

        System.out.print(sb);
    }
}
