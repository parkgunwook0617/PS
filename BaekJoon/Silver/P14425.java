import java.io.*;
import java.util.*;

public class P14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int containedListSize = Integer.parseInt(st.nextToken());
        int candidateListSize = Integer.parseInt(st.nextToken());
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        int count = 0;

        for(int i = 0; i < containedListSize; i++) {
            map.put(br.readLine(), true);
        }

        for(int i = 0; i < candidateListSize; i++) {
            String value = br.readLine();
            if(map.get(value) == null) {
                continue;
            } else if (map.get(value) == true) {
                count++;
            }
        }

        System.out.println(count);
    }
}
