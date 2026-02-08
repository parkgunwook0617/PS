import java.io.*;
import java.util.*;

public class P7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        long[] A = new long[size];
        long[] B = new long[size];
        long[] C = new long[size];
        long[] D = new long[size];

        for(int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
            C[i] = Long.parseLong(st.nextToken());
            D[i] = Long.parseLong(st.nextToken());
        }

        long[] sumAB = new long[size * size];
        long[] sumCD = new long[size * size];

        int idx = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sumAB[idx] = A[i] + B[j];
                sumCD[idx] = C[i] + D[j];
                idx++;
            }
        }

        Arrays.sort(sumAB);
        Arrays.sort(sumCD);

        long count = 0;
        int left = 0;
        int right = size * size - 1;
        while(left < size * size && right >= 0) {
            long valAB = sumAB[left];
            long valCD = sumCD[right];
            long sum = valAB + valCD;

            if (sum == 0) {
                long cntAB = 0;
                while (left < size * size && sumAB[left] == valAB) {
                    cntAB++;
                    left++;
                }
                long cntCD = 0;
                while (right >= 0 && sumCD[right] == valCD) {
                    cntCD++;
                    right--;
                }
                count += cntAB * cntCD;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);
    }
}
