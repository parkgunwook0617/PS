import java.io.*;
import java.util.*;

public class P9370 {
    public static class Node implements Comparable<Node> {
        int index;
        int cost;

        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while(testCase != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertexNumber = Integer.parseInt(st.nextToken());
            int lineNumber = Integer.parseInt(st.nextToken());
            int targetCandidate = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int startVertex = Integer.parseInt(st.nextToken());
            int middleStartVertex = Integer.parseInt(st.nextToken());
            int middleEndVertex = Integer.parseInt(st.nextToken());

            List<List<Node>> collection = new ArrayList<>();

            for(int i = 0; i <= vertexNumber; i++) {
                collection.add(new ArrayList<>());
            }

            for(int i = 0; i < lineNumber; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                collection.get(start).add(new Node(end, weight));
                collection.get(end).add(new Node(start, weight));
            }

            int[] target = new int[targetCandidate];
            for(int i = 0; i < targetCandidate; i++) {
                target[i] = Integer.parseInt(br.readLine());
            }

            int[] distanceFromStart = Dijkstra(startVertex, vertexNumber, collection);
            int[] distanceFromMiddle1 = Dijkstra(middleStartVertex, vertexNumber, collection);
            int[] distanceFromMiddle2 = Dijkstra(middleEndVertex, vertexNumber, collection);

//            for(int i = 1; i <= vertexNumber; i++) {
//                System.out.print(distanceFromStart[i] + " ");
//            }
//
//            System.out.println();
//
//            for(int i = 1; i <= vertexNumber; i++) {
//                System.out.print(distanceFromMiddle1[i] + " ");
//            }
//
//            System.out.println();
//
//            for(int i = 1; i <= vertexNumber; i++) {
//                System.out.print(distanceFromMiddle2[i] + " ");
//            }

            List<Integer> finalList = new ArrayList<>();
            if(distanceFromStart[middleStartVertex] > distanceFromStart[middleEndVertex]) {
                for(int i = 0; i < targetCandidate; i++) {
                    int shouldShortest = distanceFromStart[middleEndVertex] + distanceFromMiddle2[middleStartVertex] + distanceFromMiddle1[target[i]];
                    int realShortest = distanceFromStart[target[i]];
                    if(shouldShortest != realShortest) {
                        continue;
                    } else {
                        finalList.add(target[i]);
                    }
                }
            } else {
                for(int i = 0; i < targetCandidate; i++) {
                    int shouldShortest = distanceFromStart[middleStartVertex] + distanceFromMiddle1[middleEndVertex] + distanceFromMiddle2[target[i]];
                    int realShortest = distanceFromStart[target[i]];
                    if(shouldShortest != realShortest) {
                        continue;
                    } else {
                        finalList.add(target[i]);
                    }
                }
            }

            finalList.sort(Comparator.naturalOrder());

            for(int i = 0; i < finalList.size(); i++) {
                sb.append(finalList.get(i) + " ");
            }

            sb.append("\n");

            testCase--;
        }

        System.out.println(sb);
    }

    public static int[] Dijkstra(int startVertex, int vertexNumber, List<List<Node>> collection) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[vertexNumber + 1];
        int[] distance = new int[vertexNumber + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startVertex] = 0;

        pq.add(new Node(startVertex, 0));

        while(!pq.isEmpty()) {
            Node information = pq.poll();
            int currentVertex = information.index;
            int currentCost = information.cost;

            if(isVisited[currentVertex]) {
                continue;
            }

            isVisited[currentVertex] = true;

            for(int i = 0; i < collection.get(currentVertex).size(); i++) {
                Node nextVertex = collection.get(currentVertex).get(i);

                if(distance[nextVertex.index] > distance[currentVertex] + nextVertex.cost) {
                    distance[nextVertex.index] = distance[currentVertex] + nextVertex.cost;
                    pq.add(new Node(nextVertex.index, distance[nextVertex.index]));
                }
            }
        }

        return distance;
    }
}
