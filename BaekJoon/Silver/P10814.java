import java.io.*;
import java.util.*;

public class P10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[][] index = new String[count][2];

        for(int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            index[i][0] = st.nextToken();
            index[i][1] = st.nextToken();
        }

        Arrays.sort(index, (o1, o2) -> {
            if(Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])) {
                return 0;
            } else {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for(int i = 0; i < count; i++) {
            System.out.println(index[i][0] + " " + index[i][1]);
        }
    }
}
