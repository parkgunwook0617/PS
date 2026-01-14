import java.io.*;
import java.util.*;

public class P2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double numberCount = Double.parseDouble(br.readLine());
        double[] numberCollection = new double[(int)numberCount];
        HashMap<Double, Integer> map = new HashMap<Double,Integer>();

        //산술평균
        for(int i = 0; i < numberCount; i++) {
            numberCollection[i] = Double.parseDouble(br.readLine());
            //최빈값 계산용
            map.put(numberCollection[i], map.getOrDefault(numberCollection[i], 0) + 1);
        }

        Arrays.sort(numberCollection);

        //중앙값
        int sum = 0;
        for(int i = 0; i < numberCount; i++) {
            sum += numberCollection[i];
        }

        int max = 0;
        Queue<Double> q = new LinkedList<Double>();
        for(Map.Entry<Double, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                q = new LinkedList<Double>();
                q.add(entry.getKey());
            } else if (entry.getValue() == max) {
                q.add(entry.getKey());
            }
        }

        double[] targetList = new double[q.size()];
        int index = 0;
        for (Double value : q) {
            targetList[index++] = value;
        }

        Arrays.sort(targetList);

        System.out.println(Math.round(sum / numberCount));
        System.out.println((int)numberCollection[(int)numberCount / 2]);
        if(targetList.length > 1) {
            System.out.println((int)targetList[1]);
        } else {
            System.out.println((int)targetList[0]);
        }
        System.out.println((int)numberCollection[(int)numberCount - 1] - (int)numberCollection[0]);
    }
}
