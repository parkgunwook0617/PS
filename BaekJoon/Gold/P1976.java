import java.io.*;
import java.util.*;

public class P1976 {
    public static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityNumber = Integer.parseInt(br.readLine());
        int targetCityNumber = Integer.parseInt(br.readLine());
        list = new int[cityNumber + 1];
        Arrays.fill(list, -1);
        for(int x = 1; x <= cityNumber; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int y = 1; y <= cityNumber; y++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    union(x, y);
                }
            }
        }

        boolean isConnected = true;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int previous = Integer.parseInt(st.nextToken());

        for(int i = 0; i < targetCityNumber - 1; i++) {
            int current = Integer.parseInt(st.nextToken());
            if(find(previous) != find(current)) {
                isConnected = false;
            }

            previous = current;
        }

        if(isConnected) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
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
