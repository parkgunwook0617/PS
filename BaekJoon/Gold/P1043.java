import java.io.*;
import java.util.*;

public class P1043 {
    public static int[] person;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int personNumber = Integer.parseInt(st.nextToken());
        int partyNumber = Integer.parseInt(st.nextToken());

        person = new int[personNumber + 1];
        Arrays.fill(person, -1);

        st = new StringTokenizer(br.readLine());
        int secretNumber = Integer.parseInt(st.nextToken());
        int[] secretPeople = new int[secretNumber];
        for (int i = 0; i < secretNumber; i++) {
            secretPeople[i] = Integer.parseInt(st.nextToken());

            if (i > 0) {
                union(secretPeople[0], secretPeople[i]);
            }
        }

        List<int[]> partyLists = new ArrayList<>();
        for (int i = 0; i < partyNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int[] p = new int[count];

            for (int j = 0; j < count; j++) {
                p[j] = Integer.parseInt(st.nextToken());

                if (j > 0) {
                    union(p[0], p[j]);
                }
            }
            partyLists.add(p);
        }

        int ans = 0;
        for (int[] p : partyLists) {
            boolean canLie = true;
            for (int member : p) {
                if (secretNumber > 0 && find(member) == find(secretPeople[0])) {
                    canLie = false;
                    break;
                }
            }

            if (canLie) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static int find(int v) {
        if(person[v] < 0) {
            return v;
        }

        return person[v] = find(person[v]);
    }

    public static boolean union(int v, int u) {
        v = find(v);
        u = find(u);

        if(v == u) {
            return false;
        }

        person[v] = u;
        return true;
    }
}
