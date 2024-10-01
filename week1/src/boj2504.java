import java.util.*;
import java.io.*;

public class boj2504 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        br.close();

        Deque<Character> stack = new ArrayDeque<>();
        int temp = 1;
        int answer = 0;

        for (int i = 0; i < line.length(); ++i) {
            char current = line.charAt(i);

            if(current == '(') {
                stack.addLast(current);
                temp *= 2;
            }
            else if(current == '[') {
                stack.addLast(current);
                temp *= 3;
            }
            else {
                if(stack.isEmpty()) {
                    answer = 0;
                    break;
                }
                else {
                    char ch = stack.removeLast();
                    if(current == ')') {
                        if(ch != '(') {
                            answer = 0;
                            break;
                        } else {
                            if(line.charAt(i-1) == '(') {
                                answer += temp;
                            }
                            temp /= 2;
                        }
                    }
                    else if(current == ']') {
                        if(ch != '[') {
                            answer = 0;
                            break;
                        } else {
                            if(line.charAt(i-1) == '[') {
                                answer += temp;
                            }
                            temp /= 3;
                        }
                    }
                }
            }
        }
        if(!stack.isEmpty()) {
            answer = 0;
        }
        System.out.println(answer);
    }
}