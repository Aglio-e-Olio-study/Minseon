import java.io.*;
import java.util.*;

public class boj1764 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n+m; ++i) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0)+1);
        }

        int count = 0;
        for(String key: map.keySet()) {
            if(map.get(key) == 2) {
                count++;
                list.add(key);
            }
        }
        Collections.sort(list);

        System.out.println(count);
        for(String name: list) {
            System.out.println(name);
        }
    }
}
