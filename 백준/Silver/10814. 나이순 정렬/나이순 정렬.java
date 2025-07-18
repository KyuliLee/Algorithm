import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
    int id;
    int age;
    String name;
    public Person(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        if(this.age == o.age) {
            return this.id - o.id;
        }
        return this.age - o.age;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Person> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            pq.offer(new Person(i, age, name));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            Person p = pq.poll();
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }
        System.out.println(sb);
    }
}
