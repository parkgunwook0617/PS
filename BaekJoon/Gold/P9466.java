import java.io.*;
import java.util.*;

public class P9466 {
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseNumber = Integer.parseInt(br.readLine());

        while(testcaseNumber != 0) {
            int size = Integer.parseInt(br.readLine());
            int[] students = new int[size + 1];
            boolean[] isVisited = new boolean[size + 1];
            boolean[] isDone = new boolean[size + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 1; i <= size; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= size; i++) {
                if (!isVisited[i]) {
                    DFS(students, isVisited, isDone, i);
                }
            }

            System.out.println(size - count);

            count = 0;
            testcaseNumber--;
        }
    }

    public static void DFS(int[] students, boolean[] isVisited, boolean[] isDone, int startVertex) {
        isVisited[startVertex] = true;
        int next = students[startVertex];

        if (!isVisited[next]) {
            DFS(students, isVisited, isDone, next);
        } else {
            if (!isDone[next]) {
                count++;

                for (int i = next; i != startVertex; i = students[i]) {
                    count++;
                }
            }
        }

        isDone[startVertex] = true;
    }
}
