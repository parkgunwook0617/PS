import java.io.*;
import java.util.*;

public class P1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<String>();

        for(int i = 0; i < count; i++) {
            set.add(br.readLine());
        }

        String[] index = new String[set.size()];
        Iterator<String> iterSet = set.iterator();

        for(int i = 0; i < set.size(); i++) {
            index[i] = iterSet.next();
        }

        Arrays.sort(index, (s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }
            return s1.compareTo(s2);
        });

        for(int i = 0 ; i < set.size(); i++) {
            System.out.println(index[i]);
        }
    }
}
