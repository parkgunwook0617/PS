import java.io.*;
import java.util.*;

public class P28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<Integer>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < commandCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("1")) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            } else if (command.equals("2")) {
                deque.add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("3")) {
                if(deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.pollFirst()).append("\n");
                }
            } else if (command.equals("4")) {
                if(deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.pollLast()).append("\n");
                }
            } else if (command.equals("5")) {
                sb.append(deque.size()).append("\n");
            } else if (command.equals("6")) {
                if(deque.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (command.equals("7")) {
                if(deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.peekFirst()).append("\n");
                }
            } else if (command.equals("8")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.peekLast()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
