import java.io.*;
import java.util.*;

public class P14908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[][] target = new int[number][3];

        for(int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            target[i][0] = Integer.parseInt(st.nextToken());
            target[i][1] = Integer.parseInt(st.nextToken());
            target[i][2] = i + 1;
        }

        Arrays.sort(target, (o1, o2) -> {
           long target1 = o1[1] * o2[0];
           long target2 = o1[0] * o2[1];

           if(target1 != target2) {
               return Long.compare(target2, target1);
           }

           return Integer.compare(o1[2], o2[2]);
        });

        for(int i = 0; i < number; i++) {
            System.out.print(target[i][2] + " ");
        }
    }
}
