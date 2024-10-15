import java.io.*;
import java.util.*;

public class boj2839 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean canDeliver = true;
        int answer = 0;

        int N = Integer.parseInt(br.readLine());

        while(N % 5 != 0) {

            if(N < 0) {
                canDeliver = false;
                break;
            }
            N -= 3;
            answer++;
        }

        if(canDeliver) {
            answer += N / 5;
        } else answer = -1;

        System.out.println(answer);
    }
}
