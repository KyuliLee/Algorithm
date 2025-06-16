    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            String line;
            while(true){
                line = br.readLine();
                if(line == null) {
                    break;
                }
                sb.append(line).append("\n");
            }
            System.out.print(sb);
        }
    }
