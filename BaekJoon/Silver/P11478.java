import java.io.*;
import java.util.*;

public class P11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String candidate = br.readLine();
        HashSet<String> set = new HashSet<String>();

        for(int x = 0; x < candidate.length(); x++) {
            for(int y = x + 1; y <= candidate.length(); y++) {
                set.add(candidate.substring(x, y));
            }
        }

        System.out.println(set.size());
    }
}
