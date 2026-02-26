import java.io.*;
import java.util.*;

public class P30805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int listASize = Integer.parseInt(br.readLine());
        int[] listA = new int[listASize];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < listASize; i++) {
            listA[i] = Integer.parseInt(st.nextToken());
        }


        int listBSize = Integer.parseInt(br.readLine());
        int[] listB = new int[listBSize];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < listBSize; i++) {
            listB[i] = Integer.parseInt(st.nextToken());
        }

        int indexA = 0;
        int indexB = 0;
        List<Integer> result = new ArrayList<>();

        while(true) {
            int max = -1;
            int nextA = -1;
            int nextB = -1;

            for(int value = 100; value > 0; value--) {
                int posA = -1;
                int posB = -1;

                for (int i = indexA; i < listASize; i++) {
                    if (listA[i] == value) {
                        posA = i;
                        break;
                    }
                }

                for (int i = indexB; i < listBSize; i++) {
                    if (listB[i] == value) {
                        posB = i;
                        break;
                    }
                }

                if (posA != -1 && posB != -1) {
                    max = value;
                    nextA = posA;
                    nextB = posB;
                    break;
                }
            }

            if (max == -1) {
                break;
            }

            result.add(max);
            indexA = nextA + 1;
            indexB = nextB + 1;
        }

        System.out.println(result.size());
        StringBuilder sb = new StringBuilder();
        if(result.size() > 0) {
            for(int i = 0; i < result.size(); i++) {
                sb.append(result.get(i)).append(" ");
            }
        }
        System.out.println(sb);
    }
}
