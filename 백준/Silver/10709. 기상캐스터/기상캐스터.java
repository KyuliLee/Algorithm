import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] res = new int[H][W];

        for(int i=0; i<H; i++) {
            String str = br.readLine();
            for(int j=0; j<W; j++) {
                char ch = str.charAt(j);
                if(j==0) {
                    if(ch=='c') {
                        res[i][j] = 0;
                    } else {
                        res[i][j] = -1;
                    }
                } else {
                    if(ch=='c') {
                        res[i][j] = 0;
                    } else {
                        if(res[i][j-1] == -1) {
                            res[i][j] = -1;
                        } else {
                            res[i][j] = res[i][j-1]+1;
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
