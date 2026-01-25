import java.io.*;
import java.util.*;

public class P15651 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] candidate = new int[10];

        suyol(candidate, n, m, 0);

        System.out.println(sb);
    }

    public static void suyol(int[] candidate, int n, int m, int present) {
        if(present == m) {
            for(int i = 0; i < present; i++) {
                sb.append(candidate[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            candidate[present] = i + 1;
            suyol(candidate, n, m, present + 1);
        }
    }
}
