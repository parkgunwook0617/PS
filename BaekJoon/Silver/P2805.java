import java.io.*;
import java.util.*;

public class P2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int treeNumber = Integer.parseInt(st.nextToken());
        int needTreeLength = Integer.parseInt(st.nextToken());
        int[] treeLength = new int[treeNumber];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < treeNumber; i++) {
            treeLength[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(treeLength);

        long left = 0;
        long right = treeLength[treeNumber - 1];
        long resultHeight = 0;
        while(left <= right) {
            long mid = (left + right ) / 2;
            long sum = 0;
            for(int i = 0; i < treeNumber; i++) {
                if(treeLength[i] > mid) {
                    sum += treeLength[i] - mid;
                }
            }

            if(sum >= needTreeLength) {
                resultHeight = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(resultHeight);
    }
}
