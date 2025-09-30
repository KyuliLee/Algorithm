import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[] charArr;
    static int[] arr;
    static boolean[] visited = new boolean[10];
    static int k;
    static long maxL = -1, minL = 99876543210L;
    static String maxStr, minStr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        charArr = new char[k];
        arr = new int[k+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++) {
            charArr[i] = st.nextToken().charAt(0);
        }
        dfs(0);
        System.out.println(maxStr);
        System.out.println(minStr);

    }
    static void dfs(int depth) {
        if(depth == k+1) {
            long currNum = convertArrToLongNumber();
            if(currNum > maxL) {
                maxL = currNum;
                maxStr = String.valueOf(maxL);
                if(arr[0] == 0) {
                    maxStr = "0"+maxStr;
                }
            }
            if(currNum < minL) {
                minL = currNum;
                minStr = String.valueOf(currNum);
                if(arr[0] == 0) {
                    minStr = "0"+minStr;
                }
            }

            return;
        }
        // 반복
        for(int i=0; i<=9; i++) {
            if(visited[i]) continue;

            // depth-1번째 칸의 부등호를 확인해서 지금 i를 arr에 넣을 수 있는지 확인
            // depth가 0인 경우는 이전 부등호가 없음.
            if(depth == 0) {
                // 현재 부등호 확인. <이고 9이면 그 다음에 올 숫자가 없다. >이고 0이면 그 다음에 올 숫자가 없다. continue로 다음 숫자를 arr에 넣기
                if(charArr[0] == '<' && i == 9) continue;
                if(charArr[0] == '>' && i == 0) continue;
                visited[i] = true;
                arr[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            } else if(depth < k){
                if(charArr[depth-1] == '<') {
                    if(arr[depth-1] < i) {
                        // 현재 부등호 확인. <이고 9이면 그 다음에 올 숫자가 없다. >이고 0이면 그 다음에 올 숫자가 없다.
//                        if(charArr[depth] == '<' && i == 9) return;
//                        if(charArr[depth] == '>' && i == 0) return;

                        visited[i] = true;
                        arr[depth] = i;
                        dfs(depth+1);
                        visited[i] = false;
                    } else {
                        continue;
                    }
                } else if(charArr[depth-1] == '>'){ // charArr[depth-1] == '>') 인 경우
                    if(arr[depth-1] > i) {
                        // 부등호 확인. <이고 9이면 그 다음에 올 숫자가 없다. >이고 0이면 그 다음에 올 숫자가 없다.
//                        if(charArr[depth] == '<' && i == 9) return;
//                        if(charArr[depth] == '>' && i == 0) return;

                        visited[i] = true;
                        arr[depth] = i;
                        dfs(depth+1);
                        visited[i] = false;
                    } else {
                        continue;
                    }
                }
            } else if(depth == k) { // 마지막 칸에 숫자를 넣어서 다음 부등호를 확인할 필요가 없을 때 바로 dfs
                if(charArr[depth-1] == '<') {
                    if(arr[depth-1] < i) {
                        visited[i] = true;
                        arr[depth] = i;
                        dfs(depth+1);
                        visited[i] = false;
                    } else {
                        continue;
                    }
                } else if(charArr[depth-1] == '>') {
                    if(arr[depth-1] > i) {
                        visited[i] = true;
                        arr[depth] = i;
                        dfs(depth+1);
                        visited[i] = false;
                    } else {
                        continue;
                    }
                }
            }

        }
    }
    static long convertArrToLongNumber() {
        long ret = 0;
        for(int i=0; i<=k; i++) {
            ret += arr[i];
            ret *= 10;
        }
        return ret/10;
    }
}
