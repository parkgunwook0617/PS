import java.io.*;

public class P11729 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sb.append((int) (Math.pow(2, n) - 1)).append('\n');

        hanoi(n, 1, 3, 2);

        System.out.print(sb);
    }

    public static void hanoi(int ringNumber, int start, int target, int middle) {
        if(ringNumber == 1) {
            sb.append(start).append(" ").append(target).append('\n');

            return;
        }

        hanoi(ringNumber - 1, start, middle, target);
        sb.append(start).append(" ").append(target).append('\n');
        hanoi(ringNumber - 1, middle, target, start);

    }
}
