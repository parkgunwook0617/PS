import java.io.*;
import java.util.*;

public class P15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] candidate = new int[10];
        boolean[] isUsed = new boolean[10];

        suyol(candidate, isUsed, n, m, 0);
    }

    public static void suyol(int[] candidate, boolean[] isUsed, int n, int m, int present) {
        if(present == m) {
            for(int i = 0; i < m; i++) {
                System.out.print(candidate[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!isUsed[i]) {
                candidate[present] = i + 1;
                isUsed[i] = true;
                suyol(candidate, isUsed, n, m, present + 1);
                isUsed[i] = false;
            }
        }
    }
}
