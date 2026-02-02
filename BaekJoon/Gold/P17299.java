import java.io.*;
import java.util.*;

public class P17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            int data = Integer.parseInt(st.nextToken());
            arr[i] = data;
            map.put(data, map.getOrDefault(data, 0) + 1);
        }

        int[] result = new int[size];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < size; i++) {
            while(!stack.empty() && map.get(arr[stack.peek()]) < map.get(arr[i])) {
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
