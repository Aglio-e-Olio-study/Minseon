import java.util.*;
import java.io.*;

public class boj3107 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        if(input.endsWith(":")) input += "0";

        int count = 0;
        String temp = "";

        String[] strArray = input.split(":");

        for(String str: strArray) {

            if(str.equals("")) {
                sb.append(":");
                continue;
            }

            if(str.length() != 4) {
                sb.append("0".repeat(4-str.length()));
            }

            sb.append(str);
            sb.append(":");
            count++;

            temp = sb.toString();
        }

        sb = new StringBuilder();
        for(int i = 0; i < temp.length(); ++i) {
            if(i != temp.length()-1 && temp.charAt(i) == ':' && temp.charAt(i+1) == ':') {
                sb.append(":");
                while(count++ != 8) {
                    sb.append("0".repeat(4));
                    sb.append(":");
                }
            }
            sb.append(temp.charAt(i));
        }

        String answer = sb.toString();
        while(answer.contains("::")) {
            answer = answer.replace("::", ":");
        }

        if(answer.startsWith(":")) {
            answer = answer.substring(1);
        }

        System.out.println(answer.substring(0, answer.length()-1));
    }
}