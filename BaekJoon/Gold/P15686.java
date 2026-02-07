import java.io.*;
import java.util.*;

public class P15686 {
    public static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());
        List<int[]> chickenList = new ArrayList<>();
        List<int[]> houseList = new ArrayList<>();

        for(int x = 0; x < size; x++) {
            st = new StringTokenizer(br.readLine());

            for(int y = 0; y < size; y++) {
                int value = Integer.parseInt(st.nextToken());

                if(value == 1) {
                    houseList.add(new int[]{x, y});
                } else if (value == 2) {
                    chickenList.add(new int[]{x, y});
                }
            }
        }

        boolean[] selected = new boolean[chickenList.size()];

        simulation(chickenList, houseList, 0, 0, number, selected);

        System.out.println(minDistance);
    }

    public static void simulation(List<int[]> chickenList, List<int[]> houseList, int startPos, int selectNumber, int targetNumber, boolean[] selected) {
        if(selectNumber == targetNumber) {
            int[] distance = new int[houseList.size()];
            Arrays.fill(distance, Integer.MAX_VALUE);

            for(int i = 0; i < chickenList.size(); i++) {
                if(selected[i]) {
                    int[] chickenPosition = chickenList.get(i);

                    for(int k = 0; k < houseList.size(); k++) {
                        int[] housePosition = houseList.get(k);

                        distance[k] = Math.min(distance[k], Math.abs(chickenPosition[0] - housePosition[0]) + Math.abs(chickenPosition[1] - housePosition[1]));
                    }
                }
            }

            int totalDistance = 0;
            for(int i = 0; i < houseList.size(); i++) {
                totalDistance += distance[i];
            }

            minDistance = Math.min(minDistance, totalDistance);
        }

        for(int i = startPos; i < chickenList.size(); i++) {
            selected[i] = true;
            simulation(chickenList, houseList, i + 1, selectNumber + 1, targetNumber, selected);
            selected[i] = false;
        }
    }
}
