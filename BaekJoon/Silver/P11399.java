import java.io.*;
import java.util.*;

public class P11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int personNumber = Integer.parseInt(br.readLine());

        List<Integer> personData = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < personNumber; i++) {
            personData.add(Integer.parseInt(st.nextToken()));
        }

        personData.sort(Comparator.naturalOrder());

        int time = personData.get(0);
        int[] timeForPerson = new int[personNumber];
        timeForPerson[0] = personData.get(0);
        for(int i = 1; i < personNumber; i++) {
            timeForPerson[i] = timeForPerson[i - 1] + personData.get(i);
            time += timeForPerson[i - 1] + personData.get(i);
        }

        System.out.println(time);
    }
}
