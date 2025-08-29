import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int team1Min = 0, team1Sec = 0, team2Min = 0, team2Sec = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringTokenizer minAndSec;

        /*
        분 : 0이상, 47이하, 초 : 0이상, 59이하. 득점 시간 안 겹침
        1번 팀이 이기고 있던 시간과 2번 팀이 이기고 있던 시간 구하기
         */
        int team1 = 0, team2 = 0;
        int prevM = 0, prevS = 0;
        int min = 0, sec = 0;
        int winning = 0;

        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            minAndSec = new StringTokenizer(st.nextToken(), ":");
            min = Integer.parseInt(minAndSec.nextToken());
            sec = Integer.parseInt(minAndSec.nextToken());

            updateTime(winning, prevM, prevS, min, sec);

            if(team == 1) {
                team1++;
            } else {
                team2++;
            }
            if(team1 > team2) {
                winning = 1;
            } else if(team1 < team2) {
                winning = 2;
            } else {
                winning = 0;
            }
            prevM = min;
            prevS = sec;
        }
        min = 47;
        sec = 60;
        updateTime(winning, prevM, prevS, min, sec);

        if(team1Sec == 60) {
            team1Min++;
            team1Sec = 0;
        }
        if(team2Sec == 60) {
            team2Min++;
            team2Sec = 0;
        }
        String team1MinStr = team1Min+"";
        if(team1MinStr.length() == 1) {
            team1MinStr = "0"+team1MinStr;
        }
        String team1SecStr = team1Sec+"";
        if(team1SecStr.length() == 1) {
            team1SecStr = "0"+team1SecStr;
        }
        String team2MinStr = team2Min+"";
        if(team2MinStr.length() == 1) {
            team2MinStr = "0"+team2MinStr;
        }
        String team2SecStr = team2Sec+"";
        if(team2SecStr.length() == 1) {
            team2SecStr = "0"+team2SecStr;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(team1MinStr).append(":").append(team1SecStr).append("\n");
        sb.append(team2MinStr).append(":").append(team2SecStr);
        System.out.println(sb);

    }
    static void updateTime(int winning, int prevM, int prevS, int min, int sec) {
        if(winning == 0) return;

        if(sec < prevS) {
            min--;
            sec += 60;
        }
        if(winning == 1) {
            team1Min += (min-prevM);
            team1Sec += (sec-prevS);
            if(team1Sec > 60) {
                team1Min++;
                team1Sec -= 60;
            }
        } else {
            team2Min += min-prevM;
            team2Sec += sec-prevS;
            if(team2Sec > 60) {
                team2Min++;
                team2Sec -= 60;
            }
        }
    }
}
