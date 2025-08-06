import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr = new int[3][3];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = "";
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                str = str+Integer.parseInt(st.nextToken());
            }
        }
        map.put(str, 0);
        bfs(str);
        if(map.containsKey("123456780")) {
            System.out.println(map.get("123456780"));
        } else {
            System.out.println(-1);
        }
    }

    static void bfs(String input) {
        Queue<String> q = new LinkedList<>();
        q.offer(input);

        while(!q.isEmpty()) {
            String curr = q.poll();
            int zeroIdx = curr.indexOf("0");
            int currR = zeroIdx/3;
            int currC = zeroIdx%3;

            for(int d=0; d<4; d++) {
                int newR = currR+dr[d];
                int newC = currC+dc[d];
                if(newR<0 || newR>=3 || newC<0 || newC>=3) { continue; }
                // 2차원 인덱스를 1차원으로 변환
                int newIdx = 3*newR + newC;

                // StringBuilder의 메서드로 숫자 바꿈
                StringBuilder sb = new StringBuilder(curr);
                char c = curr.charAt(newIdx);
                sb.setCharAt(newIdx, '0');
                sb.setCharAt(zeroIdx, c);

                // 맵에 아직 없다면 방문을 안 한 것. 이 때에만 map에 넣어줌
                String newStr = new String(sb);
                if(!map.containsKey(newStr)) {
                    map.put(newStr, map.get(curr)+1);
                    q.offer(newStr);
                }
            }

        }
    }
}
