import java.io.*;
import java.util.*;

public class P15652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] candidate = new int[10];

        suyol(candidate, n, m, 0);
    }


    public static void suyol(int[] candidate, int n, int m, int present) {
        if(present == m) {
            for(int i = 0; i < m; i++) {
                System.out.print(candidate[i] + " ");
            }

            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++) {
            if(present == 0) {
                candidate[present] = i + 1;
                suyol(candidate, n, m, present + 1);
            } else {
                if(i + 1 >= candidate[present - 1]) {
                    candidate[present] = i + 1;
                    suyol(candidate, n, m, present + 1);
                }
            }
        }
    }
}
