import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        long c1 = 0;
        long c2 = 0;
        long dz = 0;
        long d = 0;
        long lj = 0;
        long nj = 0;
        long s = 0;
        long z = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'c' && i + 1 < input.length()  && input.charAt(i + 1) == '=') {
                c1++;
                i++;
                continue;
            }

            if (input.charAt(i) == 'c' && i + 1 < input.length() && input.charAt(i + 1) == '-') {
                c2++;
                i++;
                continue;
            }

            if (input.charAt(i) == 'd' && i + 1 < input.length() && input.charAt(i + 1) == 'z' && i + 2 < input.length() && input.charAt(i + 2) == '=') {
                dz++;
                i += 2;
                continue;
            }

            if (input.charAt(i) == 'd' && i + 1 < input.length() && input.charAt(i + 1) == '-') {
                d++;
                i++;
                continue;
            }

            if (input.charAt(i) == 'l' && i + 1 < input.length() && input.charAt(i + 1) == 'j') {
                lj++;
                i++;
                continue;
            }

            if (input.charAt(i) == 'n' && i + 1 < input.length() && input.charAt(i + 1) == 'j') {
                nj++;
                i++;
                continue;
            }

            if (input.charAt(i) == 's' && i + 1 < input.length() && input.charAt(i + 1) == '=') {
                s++;
                i++;
                continue;
            }

            if (input.charAt(i) == 'z' && i + 1 < input.length() && input.charAt(i + 1) == '=') {
                z++;
                i++;
            }
        }
        System.out.println(c1 + c2 + dz + d + lj + nj + s + z + (input.length() - 2 * c1 - 2 * c2 - 3 * dz - 2 * d - 2 * lj - 2 * nj - 2 * s - 2 * z));
    }
}
