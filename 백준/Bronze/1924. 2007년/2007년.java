    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            /* 풀이
            일자를 더해서 7로 나눈 나머지가 1이라면 MON, 2라면 TUE, ... 출력
            x월 y일이 1월 2일이라면 2/7=2 이므로 TUE
            2월 2일이라면 31+2를 7로 나눔
             */

            int num = -1;
            if(x==1) {
                num = y%7;
            } else if(x==2) {
                num = (31+y)%7;
            } else if(x==3) {
                num = (31+28+y)%7;
            } else if(x==4) {
                num = (31+28+31+y)%7;
            } else if(x==5) {
                num = (31+28+31+30+y)%7;
            } else if(x==6) {
                num = (31+28+31+30+31+y)%7;
            } else if(x==7) {
                num = (31+28+31+30+31+30+y)%7;
            } else if(x==8) {
                num = (31+28+31+30+31+30+31+y)%7;
            } else if(x==9) {
                num = (31+28+31+30+31+30+31+31+y)%7;
            } else if(x==10) {
                num = (31+28+31+30+31+30+31+31+30+y)%7;
            } else if(x==11) {
                num = (31+28+31+30+31+30+31+31+30+31+y)%7;
            } else if(x==12) {
                num = (31+28+31+30+31+30+31+31+30+31+30+y)%7;
            }
            switch(num) {
                case 1:
                    System.out.println("MON");
                    break;
                case 2:
                    System.out.println("TUE");
                    break;
                case 3:
                    System.out.println("WED");
                    break;
                case 4:
                    System.out.println("THU");
                    break;
                case 5:
                    System.out.println("FRI");
                    break;
                case 6:
                    System.out.println("SAT");
                    break;
                case 0:
                    System.out.println("SUN");
                    break;
            }

        }
    }
