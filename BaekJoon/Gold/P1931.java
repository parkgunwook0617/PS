import java.io.*;
import java.util.*;

public class P1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int courseNumber = Integer.parseInt(br.readLine());
        int[][] courseData = new int[courseNumber][2];

        for(int i = 0; i < courseNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            courseData[i][0] = Integer.parseInt(st.nextToken());
            courseData[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(courseData, (o1, o2) -> {
           if(o1[1] == o2[1]) {
               return o1[0] - o2[0];
           } else {
               return o1[1] - o2[1];
           }
        });

        int end = courseData[0][1];
        int number = 1;
        for(int i = 1; i < courseNumber; i++) {
            if(end <= courseData[i][0]) {
                end = courseData[i][1];
                number++;
            }
        }

        System.out.println(number);
    }
}
