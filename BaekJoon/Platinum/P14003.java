import java.io.*;
import java.util.*;

public class P14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        list.add(Integer.parseInt(st.nextToken()));
        int[] numbers = new int[size];
        int[] savedIndex = new int[size];
        savedIndex[0] = 1;
        numbers[0] = list.get(0);

        for(int i = 1; i < size; i++) {
            int nextValue = Integer.parseInt(st.nextToken());
            numbers[i] = nextValue;

            int currentMax = list.get(list.size() - 1);

            if(nextValue > currentMax) {
                list.add(nextValue);
                savedIndex[i] = list.size();
            } else if (nextValue < currentMax) {
                int index = Collections.binarySearch(list, nextValue);

                if (index < 0) {
                    index = -(index + 1);
                }

                list.set(index, nextValue);
                savedIndex[i] = index + 1;
            } else {
                savedIndex[i] = -1;
            }
        }

        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        int count = list.size();
        for(int i = size - 1; i >= 0; i--) {
            if(savedIndex[i] == count) {
                stack.push(numbers[i]);
                count--;
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }


        System.out.println(sb);
    }
}
