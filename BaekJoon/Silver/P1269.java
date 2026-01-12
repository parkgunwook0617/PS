import java.io.*;
import java.util.*;

public class P1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int list1Count = Integer.parseInt(st.nextToken());
        int list2Count = Integer.parseInt(st.nextToken());

        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < list1Count; i++) {
            map.put(Integer.parseInt(st.nextToken()), true);
        }

        st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int i = 0; i < list2Count; i++) {
            int value = Integer.parseInt(st.nextToken());

            if(map.get(value) == null) {
                continue;
            } else {
                count++;
            }
        }

        System.out.println(list1Count + list2Count - 2 * count);
    }
}
