import java.io.*;
import java.util.*;

public class P10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberCount = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < numberCount; i++) {
            Integer value = Integer.parseInt(st.nextToken());
            if(map.get(value) == null) {
                map.put(value, 1);
            } else {
                map.put(value, map.get(value) + 1);
            }
        }

        int candidateCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < candidateCount; i++) {
            int value = Integer.parseInt(st.nextToken());

            if(map.get(value) == null) {
                sb.append("0 ");
            } else {
                sb.append(map.get(value)).append(" ");
            }
        }

        System.out.println(sb);
    }
}
