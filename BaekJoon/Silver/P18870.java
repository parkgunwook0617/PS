import java.io.*;
import java.util.*;

public class P18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] index = new int[count];
        int[] score = new int[count];
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < count; i++) {
            index[i] = Integer.parseInt(st.nextToken());
            set.add(index[i]);
        }

        Iterator<Integer> iterSet = set.iterator();
        int[] targetList = new int[set.size()];

        for(int i = 0; i < set.size(); i++) {
            targetList[i] = iterSet.next();
        }

        Arrays.sort(targetList);

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < targetList.length; i++) {
            map.put(targetList[i], i);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < count; i++) {
            sb.append(map.get(index[i])).append(" ");
        }

        System.out.println(sb.toString());
    }
}
