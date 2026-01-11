import java.io.*;
import java.util.*;

public class P11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[][] index = new int[count][2];

        for(int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            index[i][0] = Integer.parseInt(st.nextToken());
            index[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(index, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        for(int i = 0; i < count; i++) {
            System.out.println(index[i][0] + " " + index[i][1]);
        }
    }
}
