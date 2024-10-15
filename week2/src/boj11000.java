import java.util.*;
import java.io.*;

class Lecture {
    int start;
    int end;

    Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class boj11000 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Lecture[] list = new Lecture[n];
        for(int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list[i] = new Lecture(s, t);
        }

        Arrays.sort(list, (l1, l2) -> l1.start == l2.start ? l1.end - l2.end : l1.start - l2.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; ++i) {
            if(pq.isEmpty()) {
                pq.add(list[i].end);
                continue;
            }

            if(list[i].start < pq.peek()) {
                pq.add(list[i].end);
            }
            else {
                pq.poll();
                pq.add(list[i].end);
            }
        }

        System.out.println(pq.size());
    }
}