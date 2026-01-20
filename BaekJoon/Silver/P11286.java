import java.io.*;
import java.util.*;

public class P11286 {
    public static class Number implements Comparable<Number> {
        long number;

        Number(long number) {
            this.number = number;
        }

        @Override
        public int compareTo(Number o) {
            long number1 = Math.abs(this.number);
            long number2 = Math.abs(o.number);
            if(number1 == number2) {
                return Long.compare(this.number, o.number);
            } else {
                return Long.compare(number1, number2);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int commandNumber = Integer.parseInt(br.readLine());
        PriorityQueue<Number> pq = new PriorityQueue<>();

        for(int i = 0; i < commandNumber; i++) {
            long command = Long.parseLong(br.readLine());
            if(command == 0) {
                if(pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll().number);
                }
            } else {
                pq.add(new Number(command));
            }
        }
    }
}
