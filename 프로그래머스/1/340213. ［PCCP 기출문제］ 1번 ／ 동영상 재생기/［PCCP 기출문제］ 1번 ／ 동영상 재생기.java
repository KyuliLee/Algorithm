import java.util.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int maxmm = convertToInt(video_len.substring(0, 2));
        int maxss = convertToInt(video_len.substring(3, 5));
        int mm = convertToInt(pos.substring(0, 2));
        int ss = convertToInt(pos.substring(3, 5));
        int startmm = convertToInt(op_start.substring(0, 2));
        int startss = convertToInt(op_start.substring(3, 5));
        int endmm = convertToInt(op_end.substring(0, 2));
        int endss = convertToInt(op_end.substring(3, 5));
        
        // 오프닝 위치이면 오프닝 끝날 때로 이동
        if(startmm < endmm) {
            if(mm == startmm) {
                if(ss >= startss) {
                    mm = endmm;
                    ss = endss;
                }
            } else if(mm > startmm && mm < endmm) {
                mm = endmm;
                ss = endss;
            } else if(mm == endmm) {
                if(ss < endss) {
                    ss = endss;
                }
            }
        } else { // 로직 상 startmm == endmm
            if(mm == endmm) {
                if(ss >= startss && ss < endss) {
                    ss = endss;
                }
            }
        }

        for(int i=0; i<commands.length; i++) {
            System.out.println(mm + " : " + ss);
            if(commands[i].equals("next")) {
                ss += 10;
                if(ss>=60) {
                    mm++;
                    ss -= 60;
                }
                // 최대 위치 넘어갔나 확인
                if(mm>maxmm) {
                    mm = maxmm;
                    ss = maxss;
                }
                if(mm==maxmm && ss>maxss) {
                    ss = maxss;
                } 
                // // 오프닝 위치이면 오프닝 끝날 때로 이동
                if(startmm < endmm) {
                    if(mm == startmm) {
                        if(ss >= startss) {
                            mm = endmm;
                            ss = endss;
                        }
                    } else if(mm > startmm && mm < endmm) {
                        mm = endmm;
                        ss = endss;
                    } else if(mm == endmm) {
                        if(ss < endss) {
                            ss = endss;
                        }
                    }
                } else { // 로직 상 startmm == endmm
                    if(mm == endmm) {
                        if(ss >= startss && ss < endss) {
                            ss = endss;
                        }
                    }
                }

            }
            else if(commands[i].equals("prev")) {
                ss -= 10;
                if(ss<0) {
                    mm--;
                    ss += 60;
                }
                // 00:00보다 작은지 확인
                if(mm<0) {
                    mm = 0;
                    ss = 0;
                }
                
                // 오프닝 위치이면 오프닝 끝날 때로 이동
                // 오프닝 - 10:15 ~ 11:10
                // 현재눙 - 10:23
                // 오프닝 - 10:15 ~ 11:17
                // 현재눙 - 10:23
                // 오프닝 - 10:10 ~ 11:56
                // 현재눙 - 11:23
                // 오프닝 - 10:00 ~ 10:56
                // 현재눙 - 10:12
                if(startmm < endmm) {
                    if(mm == startmm) {
                        if(ss >= startss) {
                            mm = endmm;
                            ss = endss;
                        }
                    } else if(mm > startmm && mm < endmm) {
                        mm = endmm;
                        ss = endss;
                    } else if(mm == endmm) {
                        if(ss < endss) {
                            ss = endss;
                        }
                    }
                } else { // 로직 상 startmm == endmm
                    if(mm == endmm) {
                        if(ss >= startss && ss < endss) {
                            ss = endss;
                        }
                    }
                }
            }
        }
        
        
        String mmStr = convertToString(mm);
        String ssStr = convertToString(ss);
        System.out.println(mmStr + ":" + ssStr);
        return mmStr+":"+ssStr;

    }
    static int convertToInt(String str) {
        return 10*(str.charAt(0)-'0') + (str.charAt(1)-'0');
    }
    static String convertToString(int num) {
        if(num<10) {
            return "0"+num;
        }
        return num+"";
    }
}