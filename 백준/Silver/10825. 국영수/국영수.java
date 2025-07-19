import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Student implements Comparable<Student>{
    String name;
    int korean;
    int english;
    int math;
    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Student o) {
        if(this.korean == o.korean) {
            if(this.english == o.english) {
                if(this.math == o.math) {
                    return this.name.compareTo(o.name);
                }
                return o.math - this.math;
            }
            return this.english - o.english;
        }
        return o.korean - this.korean;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Student> pq = new PriorityQueue<>();
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Student(st.nextToken(), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(pq.poll().name).append("\n");
        }
        System.out.println(sb);
    }
}
