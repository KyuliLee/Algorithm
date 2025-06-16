    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            int length = line.length();
            int num = length/10;
            StringBuilder sb = new StringBuilder();
            int beginIdx = 0;
            int endIdx = 10;
            for(int i = 0; i<num; i++) {
                String subStr = line.substring(beginIdx, endIdx);
                sb.append(subStr).append("\n");
                beginIdx += 10;
                endIdx += 10;
            }
            String subStr = line.substring(beginIdx, length);
            sb.append(subStr);

            System.out.print(sb);
        }
    }
