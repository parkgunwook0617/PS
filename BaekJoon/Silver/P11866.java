import java.io.*;
import java.util.*;

public class P11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int person = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i = 1; i <= person; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!q.isEmpty()) {
            for(int i = 0; i < order - 1; i++) {
                int changedValue = q.poll();
                q.add(changedValue);
            }

            sb.append(q.poll() + ", ");
        }

        sb.setCharAt(sb.length() - 2, '>');

        System.out.println(sb);
    }
}
