public class boj4673 {
    public static void main(String[] args) {
        int n = 10000;
        boolean[] check = new boolean[n];

        for(int i = 1; i <= n; ++i) {
            int num = i;

            String nStr = String.valueOf(num);
            for (int j = 0; j < nStr.length(); ++j) {
                num += nStr.charAt(j) - '0';
            }
            if(num > n) continue;

            check[num-1] = true;
        }

        for(int i = 0; i < n; ++i) {
            if (!check[i]) {
                System.out.println(i+1);
            }
        }
    }
}
