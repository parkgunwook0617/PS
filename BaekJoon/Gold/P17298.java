import java.io.*;
import java.util.*;

public class P17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];
        int[] result = new int[size];
        Arrays.fill(result, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < size; i++) {
            while(!stack.empty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}
