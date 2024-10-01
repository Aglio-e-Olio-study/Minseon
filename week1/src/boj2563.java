import java.io.*;
import java.util.*;

public class boj2563 {
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;
        int[][] borad = new int[101][101];

        int tCase = Integer.parseInt(br.readLine());
        while(tCase-- > 0) {

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int i = x; i < x+10; ++i) {
                for(int j = y; j < y+10; ++j) {
                    borad[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < 101; ++i) {
            for(int j = 0; j < 101; ++j) {
                if(borad[i][j] == 1) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
