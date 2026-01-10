import java.io.*;
import java.util.*;

public class P11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[][] targetArray = new int[count][2];

        for(int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            targetArray[i][0] = Integer.parseInt(st.nextToken());
            targetArray[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(targetArray, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < count; i++) {
            System.out.println(targetArray[i][0] + " " + targetArray[i][1]);
        }
    }
}
