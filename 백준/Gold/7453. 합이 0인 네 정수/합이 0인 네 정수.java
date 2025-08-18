import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static long cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][4];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] ab = new int[n*n];
        int[] cd = new int[n*n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n ;j++) {
                ab[i*n+j] = arr[i][0] + arr[j][1];
                cd[i*n+j] = arr[i][2] + arr[j][3];
            }
        }
        int abp = 0;
        int cdp = n*n-1;
        Arrays.sort(ab);
        Arrays.sort(cd);

        while(abp < n*n && cdp >= 0) {
            int sum = ab[abp] + cd[cdp];
            if(sum < 0) {
                abp++;
            } else if(sum > 0) {
                cdp--;
            } else {
                long abCnt = 0;
                int abV = ab[abp];
                while(abp < n*n && ab[abp] == abV) {
                    abCnt++;
                    abp++;
                }
                long cdCnt = 0;
                int cdV = cd[cdp];
                while(cdp >= 0 && cd[cdp] == cdV) {
                    cdCnt++;
                    cdp--;
                }
                cnt += (abCnt * cdCnt);
            }

        }

        System.out.println(cnt);
    }

}
