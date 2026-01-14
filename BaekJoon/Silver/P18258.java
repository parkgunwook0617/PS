import java.io.*;
import java.util.*;

public class P18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<Integer>();
        int back = -1;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < commandCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                q.add(value);
                back = value;
            } else if (command.equals("pop")) {
                if(q.isEmpty()) {
                    sb.append(-1).append("\n");;
                } else {
                    int value = q.poll();
                    sb.append(value).append("\n");
                }
            } else if (command.equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (command.equals("empty")) {
                if(q.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (command.equals("front")) {
                if(q.isEmpty()) {
                    sb.append(-1).append("\n");;
                } else {
                    sb.append(q.peek()).append("\n");
                }
            } else if (command.equals("back")) {
                if(q.isEmpty()) {
                    sb.append(-1).append("\n");;
                } else {
                    sb.append(back).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
