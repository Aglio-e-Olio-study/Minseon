import java.util.*;
import java.io.*;

public class boj15927 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int answer = 0;
        boolean flag = false;

        String str = br.readLine();

        for(int i = 0; i < str.length()/2; ++i) {
            if(str.charAt(i) != str.charAt(str.length()-i-1)) {
                answer = str.length();
                System.out.println(answer);
                return;
            } else if(str.charAt(i) != str.charAt(i+1)) {
                flag = true;
            }
        }

        if(flag) answer = str.length() -1;
        else answer = -1;

        System.out.println(answer);

    }
}
