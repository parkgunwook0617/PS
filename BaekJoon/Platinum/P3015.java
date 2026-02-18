import java.io.*;
import java.util.*;

public class P3015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int personNumber = Integer.parseInt(br.readLine());

        Stack<int[]> stack = new Stack<>();

        long total = 0;
        while(personNumber != 0) {
            int nextPerson = Integer.parseInt(br.readLine());

            if(stack.isEmpty()) {
                stack.push(new int[]{nextPerson, 1});
                personNumber--;
                continue;
            }

            while (!stack.isEmpty() && stack.peek()[0] < nextPerson) {
                total += stack.pop()[1];
            }

            if(!stack.isEmpty()) {
                if(nextPerson < stack.peek()[0]) {
                    total += 1;
                    stack.push(new int[]{nextPerson, 1});
                } else if (nextPerson == stack.peek()[0]) {
                    int[] currentData = stack.pop();
                    total += currentData[1];

                    if(!stack.isEmpty()) {
                        total += 1;
                    }

                    currentData[1] += 1;
                    stack.push(currentData);
                }
            } else {
                stack.push(new int[]{nextPerson, 1});
            }

            personNumber--;
        }

        System.out.println(total);
    }
}
