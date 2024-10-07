import java.util.*;
import java.io.*;

public class boj1966 {
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tCase = Integer.parseInt(br.readLine());

        while(tCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            LinkedList<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; ++i) {
                q.add(new int[] {i, Integer.parseInt(st.nextToken())});
            }

            int answer = 0;
            while(!q.isEmpty()) {
                boolean isMax = true;

                int[] front = q.poll();

                for (int i = 0; i < q.size(); ++i) {
                    if (front[1] < q.get(i)[1]) {
                        isMax = false;
                        q.add(front);

                        for (int j = 0; j < i; ++j) {
                            q.add(q.poll());
                        }
                        break;
                    }
                }

                if (isMax) {
                    answer++;
                    if (front[0] == m) break;
                }
            }

            System.out.println(answer);
        }
    }
}