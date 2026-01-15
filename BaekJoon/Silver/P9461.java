import java.io.*;

public class P9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] pn = new long[101];
        pn[0] = 1;
        pn[1] = 1;
        pn[2] = 1;

        for(int i = 3; i < 101; i++) {
            pn[i] = pn[i - 2] + pn[i - 3];
        }

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(pn[Integer.parseInt(br.readLine()) - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
