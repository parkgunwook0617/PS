import java.io.*;
import java.util.*;

public class P1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int list1 = Integer.parseInt(st.nextToken());
        int list2 = Integer.parseInt(st.nextToken());
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();

        for(int i = 0; i < list1; i++) {
            map.put(br.readLine(), true);
        }

        int count = 0;
        ArrayList<String> memberCounter = new ArrayList<String>();
        for(int i = 0; i < list2; i++) {
            String value = br.readLine();

            if(map.get(value) == null) {
                continue;
            } else {
                memberCounter.add(value);
                count++;
            }
        }

        String[] memberList = memberCounter.toArray(new String[0]);
        Arrays.sort(memberList);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++) {
            sb.append(memberList[i]).append("\n");
        }

        System.out.println(count);
        System.out.println(sb);
    }
}
