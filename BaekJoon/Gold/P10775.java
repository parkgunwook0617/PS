import java.io.*;
import java.util.*;

public class P10775 {
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int gateNumber = Integer.parseInt(br.readLine());
        int flightNumber = Integer.parseInt(br.readLine());

        parent = new int[gateNumber + 1];
        for (int i = 1; i <= gateNumber; i++) {
            parent[i] = i;
        }

        int maxFlight = 0;

        for(int i = 0; i < flightNumber; i++) {
            int maxStation = Integer.parseInt(br.readLine());

            int emptyGate = find(maxStation);

            if (emptyGate == 0) {
                break;
            }

            maxFlight++;

            union(emptyGate, emptyGate - 1);
        }

        System.out.println(maxFlight);
    }

    public static int find(int i) {
        if (parent[i] == i) return i;

        return parent[i] = find(parent[i]);
    }

    public static void union(int i, int j) {
        i = find(i);
        j = find(j);

        if (i != j) {
            parent[i] = j;
        }
    }
}
