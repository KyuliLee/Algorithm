import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Person1 implements Comparable<Person1>{
    int year;
    public Person1(int year) {
        this.year = year;
    }

    @Override
    public int compareTo(Person1 p) { // 연도별로 오름차순
        return this.year - p.year;
    }

}

class Person2 implements Comparable<Person2>{
    int problem;
    String name;
    public Person2(int problem, String name) {
        this.problem = problem;
        this.name = name;
    }

    @Override
    public int compareTo(Person2 p) { // 문제 수 내림차순 정렬
        return p.problem - this.problem;
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Person1> pq1 = new PriorityQueue<>();
        PriorityQueue<Person2> pq2 = new PriorityQueue<>();
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken())%100;
            String name = st.nextToken();
            pq1.offer(new Person1(year));
            pq2.offer(new Person2(p, name));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq1.isEmpty()) {
            sb.append(pq1.poll().year);
        }
        sb.append("\n");
        while(!pq2.isEmpty()) {
            char c = pq2.poll().name.charAt(0);
            sb.append(c);
        }
        System.out.println(sb);
    }
}
