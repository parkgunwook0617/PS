import java.io.*;
import java.util.*;

public class P12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        list.add(Integer.parseInt(st.nextToken()));

        for(int i = 0; i < size - 1; i++) {
            int nextValue = Integer.parseInt(st.nextToken());

            if(nextValue > list.get(list.size() - 1)) {
                list.add(nextValue);
            } else if (nextValue < list.get(list.size() - 1)) {
                int index = Collections.binarySearch(list, nextValue);

                if(index < 0) {
                    index = -(index + 1);
                }

                list.set(index, nextValue);
            }
        }

        System.out.println(list.size());
    }
}
