import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class boj13305 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] roadLen = new int[n-1];
        int[] costs = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n-1; ++i) {
            roadLen[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        BigInteger answer = new BigInteger("0");
        int minValue = costs[0];

        for(int i = 0; i < n-1; ++i) {
            if(minValue > costs[i]) {
                minValue = costs[i];
            }

            BigInteger minTemp = new BigInteger(String.valueOf(minValue));
            BigInteger mulTemp = minTemp.multiply(BigInteger.valueOf(roadLen[i]));

            answer = answer.add(mulTemp);
        }

        System.out.println(answer);
    }
}