import java.io.*;
import java.util.*;

public class Main {
    static class SAM {
        // 최대 상태 수: 2 * n
        int[][] next;
        int[] link, len;
        int size, last;

        SAM(int n) {
            next = new int[2 * n][26];
            for (int i = 0; i < 2 * n; i++) Arrays.fill(next[i], -1);
            link = new int[2 * n];
            len = new int[2 * n];
            Arrays.fill(link, -1);
            size = 1; // root = 0
            last = 0;
        }

        void extend(int c) {
            int cur = size++;
            len[cur] = len[last] + 1;
            int p = last;

            while (p != -1 && next[p][c] == -1) {
                next[p][c] = cur;
                p = link[p];
            }

            if (p == -1) {
                link[cur] = 0;
            } else {
                int q = next[p][c];
                if (len[p] + 1 == len[q]) {
                    link[cur] = q;
                } else {
                    int clone = size++;
                    System.arraycopy(next[q], 0, next[clone], 0, 26);
                    len[clone] = len[p] + 1;
                    link[clone] = link[q];
                    while (p != -1 && next[p][c] == q) {
                        next[p][c] = clone;
                        p = link[p];
                    }
                    link[q] = link[cur] = clone;
                }
            }
            last = cur;
        }

        long countDistinctSubstrings() {
            long res = 0;
            for (int v = 1; v < size; v++) {
                res += (long) (len[v] - len[link[v]]);
            }
            return res;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        SAM sam = new SAM(S.length());
        for (int i = 0; i < S.length(); i++) {
            sam.extend(S.charAt(i) - 'a');
        }
        System.out.println(sam.countDistinctSubstrings());
    }
}
