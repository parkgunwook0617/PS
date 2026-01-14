import java.io.*;
import java.util.*;

public class P26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int meetingCount = Integer.parseInt(br.readLine());
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();

        map.put("ChongChong", true);

        for(int i = 0; i < meetingCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String person1 = st.nextToken();
            String person2 = st.nextToken();

            if(map.getOrDefault(person1, false)) {
                map.put(person2, true);
            } else if (map.getOrDefault(person2, false)) {
                map.put(person1, true);
            }
        }

        int count = 0;
        for(Map.Entry<String, Boolean> entry : map.entrySet()) {
            if(entry.getValue() == true) {
                count++;
            }
        }

        System.out.println(count);
    }
}
