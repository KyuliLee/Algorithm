import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N==1) {
            System.out.println("*");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=4*N-3; i++) {
            sb.append("*");
        }
        sb.append("\n");

        for(int i=1; i<=2*N-3; i++) {
            if(i%2==1) {
                for(int j=1; j<=4*N-3; j++) {
                    if(j%2==1 && (j<=i || j+i>4*N-3)) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                }
            } else {
                for(int j=1; j<=4*N-3; j++) {
                    if(j%2==1 && (j<i || j+i>4*N-3)) {
                        sb.append("*");
                    } else if(j%2==0 && (j<=i || j+i>4*N-3)) {
                        sb.append(" ");
                    } else {
                        sb.append("*");
                    }
                }
            }
            sb.append("\n");
        }

        for(int i=1; i<=4*N-3; i++) {
            if(i%2==1) {
                sb.append("*");
            } else {
                sb.append(" ");
            }
        }
        sb.append("\n");

        for(int i=2*N-3; i>=1; i--) {
            if(i%2==1) {
                for(int j=1; j<=4*N-3; j++) {
                    if(j%2==1 && (j<=i || j+i>4*N-3)) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                }
            } else {
                for(int j=1; j<=4*N-3; j++) {
                    if(j%2==1 && (j<i || j+i>4*N-3)) {
                        sb.append("*");
                    } else if(j%2==0 && (j<=i || j+i>4*N-3)) {
                        sb.append(" ");
                    } else {
                        sb.append("*");
                    }
                }
            }
            sb.append("\n");
        }

        for(int i=1; i<=4*N-3; i++) {
            sb.append("*");
        }

        System.out.println(sb);
    }
}
