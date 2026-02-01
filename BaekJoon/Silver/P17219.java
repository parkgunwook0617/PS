import java.io.*;
import java.util.*;

public class P17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int siteNumber = Integer.parseInt(st.nextToken());
        int findNumber = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();

        for(int i = 0; i < siteNumber; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        for(int i = 0; i < findNumber; i++) {
            System.out.println(map.get(br.readLine()));
        }
    }
}
