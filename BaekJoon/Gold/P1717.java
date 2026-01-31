import java.io.*;
import java.util.*;

public class P1717 {
    public static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int commandNumber = Integer.parseInt(st.nextToken());
        list = new int[size + 1];
        Arrays.fill(list, -1);

        for(int i = 0; i < commandNumber; i++) {
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken()) == 0) {
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else {
                if(find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken()))) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static int find(int i) {
        while(list[i] >= 0) {
            i = list[i];
        }

        return i;
    }

    public static boolean union(int v, int u) {
        v = find(v);
        u = find(u);

        if(v == u) {
            return false;
        }

        list[u] = v;
        return true;
    }
}
