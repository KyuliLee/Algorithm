class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int max = convertToSec(video_len);
        int curr = convertToSec(pos);
        int start = convertToSec(op_start);
        int end = convertToSec(op_end);
        
        // 현재 위치가 오프닝 위치인지 확인
        if(curr >= start && curr < end) {
            curr = end;
        }
        
        for(String cmd : commands) {
            if(cmd.equals("next")) {
                curr += 10;
                if(curr > max) {
                    curr = max;
                }
                // 현재 위치가 오프닝 위치인지 확인
                if(curr >= start && curr < end) {
                    curr = end;
                }
            } else {
                curr -= 10;
                if(curr < 0) {
                    curr = 0;
                }
                // 현재 위치가 오프닝 위치인지 확인
                if(curr >= start && curr < end) {
                    curr = end;
                }
            }
        }
        // 현재 초를 문자열로 바꾸기
        int m = curr/60;
        int s = curr%60;
        String mm = "";
        String ss = "";
        if(m<10) {
            mm = "0"+m;
        } else {
            mm = m+"";
        }
        if(s<10) {
            ss = "0"+s;
        } else {
            ss = s+"";
        }
        return mm+":"+ss;
    }
    static int convertToSec(String time) {
        char[] arr = time.toCharArray();
        int m = (arr[0]-'0')*10 + (arr[1]-'0');
        int s = (arr[3]-'0')*10 + (arr[4]-'0');
        return m*60+s;
    }
}