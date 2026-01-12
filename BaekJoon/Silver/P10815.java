import java.io.*;
import java.util.*;

public class P10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int SangunCount = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] SangunDeck = new int[SangunCount];

        for(int i = 0; i < SangunCount; i++) {
            SangunDeck[i] = Integer.parseInt(st.nextToken());
        }

        int cardCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] cardDeck = new int[cardCount];

        for(int i = 0; i < cardCount; i++) {
            cardDeck[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        for(int i = 0; i < SangunCount; i++) {
            map.put(SangunDeck[i], true);
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cardCount; i++) {
            if(map.get(cardDeck[i]) == null) {
                sb.append("0 ");
            } else {
                sb.append("1 ");
            }
        }

        System.out.println(sb);
    }
}
