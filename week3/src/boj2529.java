import java.io.*;
import java.util.*;

public class boj2529 {

    private static int n;
    private static char[] cArray;
    private static List<String> temp;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        cArray = br.readLine().replace(" ", "").toCharArray();

        List<Integer> list = new ArrayList<>();
        temp = new ArrayList<>();
        visited = new boolean[10];

        backTracking(0, list);

        System.out.println(temp.get(temp.size()-1));
        System.out.println(temp.get(0));


    }

    private static void backTracking(int len, List<Integer> list) {
        if(len == n+1) {
            StringBuilder sb = new StringBuilder();
            for(int elem: list) {
                sb.append(elem);
            }
            temp.add(sb.toString());
        }
        else {
            if(len == 0) {
                for(int i = 0; i < 10; ++i) {
                    add(i, list);
                    backTracking(list.size(), list);

                    clear(i, list);
                }
            }
            else {
                char c = cArray[len-1];
                for(int i = 0; i < 10; ++i) {

                    if(c == '<') {
                        if(!visited[i] && list.get(list.size()-1) < i) {
                            add(i, list);
                            backTracking(list.size(), list);

                            clear(i, list);
                        }
                    } else if (c == '>'){
                        if(!visited[i] && list.get(list.size()-1) > i) {
                            add(i, list);
                            backTracking(list.size(), list);

                            clear(i, list);
                        }
                    }
                }
            }
        }
    }

    private static void add(int idx, List<Integer> list) {
        list.add(idx);
        visited[idx] = true;
    }

    private static void clear(int idx, List<Integer> list) {
        list.remove(list.size()-1);
        visited[idx] = false;
    }
}
