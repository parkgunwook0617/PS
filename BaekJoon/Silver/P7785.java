import java.io.*;
import java.util.*;

public class P7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int memberCount = Integer.parseInt(br.readLine());
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        HashSet<String> set = new HashSet<String>();

        for(int i = 0; i < memberCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String member = st.nextToken();
            String status = st.nextToken();

            set.add(member);

            if(status.equals("enter")) {
                map.put(member, true);
            } else {
                map.put(member, false);
            }
        }

        Iterator<String> iterSet = set.iterator();

        ArrayList<String> stayedList = new ArrayList<String>();
        for(int i = 0; i < set.size(); i++) {
            String name = iterSet.next();
            if(map.get(name) == true) {
                stayedList.add(name);
            }
        }

        String[] finalResult = stayedList.toArray(new String[0]);

        Arrays.sort(finalResult, (o1, o2) -> {
            return o2.compareTo(o1);
        });

        for(int i = 0; i < finalResult.length; i++) {
            System.out.println(finalResult[i]);
        }
    }
}
