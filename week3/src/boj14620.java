import java.io.*;
import java.util.*;

public class boj14620 {

    private static int answer = Integer.MAX_VALUE;
    private static int N;
    private static boolean[][] visited;
    private static int[][] ground;
    private static int[] dx = new int[] {-1, 0, 1, 0};
    private static int[] dy = new int[] {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ground = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int depth, int sum) {
        if(depth == 3) {
            answer = Math.min(answer, sum);
        }
        else {
            int cost = sum;

            for(int i = 1; i < N-1; ++i) {
                for(int j = 1; j < N-1; ++j) {

                    if(!visited[i][j] && canGrow(i,j)) {
                        cost += cost(i, j);
                        visitCheck(i, j);
                        dfs(depth+1, cost);

                        init(i, j);
                        cost -= cost(i, j);
                    }

                }
            }

        }
    }

    private static boolean canGrow(int x, int y) {
        for(int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(visited[nx][ny]) {
                return false;
            }
        }
        return true;
    }

    private static int cost(int x, int y) {
        int cost = ground[x][y];

        for(int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            cost += ground[nx][ny];
        }

        return cost;
    }

    private static void visitCheck(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            visited[nx][ny] = true;
        }
    }

    private static void init(int x, int y) {
        visited[x][y] = false;

        for(int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            visited[nx][ny] = false;
        }
    }
}