package week2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class BOJ_11003_최솟값_찾기 {

	public static void main(String[] args) throws IOException {
		
		// 수도 코드
		// 일정한 크기 L에서 최솟값 찾기 
		// -> 슬라이딩 윈도우
		// 값도 신경써야 하고 몇 번째 값인지도 신경써야 한다.
		// -> value와 index를 멤버 변수로 갖는 클래스 Node를 만들어서 value를 기준으로 정렬하자.
		// deque를 사용해서 앞과 뒤에서 모두 데이터의 추가, 제거가 가능하게 하자.
		// 값이 새로 들어올 때 만약 deque가 비어있지 않고
		// deque의 마지막에 있는 Node의 value와 비교해서
		// 원래 있던 값이 더 크면 deque의 마지막 Node 삭제
		// deque가 비어있지 않다면 또 다시 비교.
		// deque가 비어있다면 Node 넣기
		// 만약 인덱스의 범위가 L 보다 크거나 같다면 맨 앞의 Node 삭제
		// => deque의 맨 앞 노드의 value가 해당 L에서의 최솟값
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// deque를 선언하고 맨 처음 노드는 deque에 바로 넣는다.
		Deque<Node> deque = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			while(!deque.isEmpty() && deque.getLast().value > now) {
				deque.removeLast();
			}
			
			deque.addLast(new Node(now, i));
			
			if(i - deque.getFirst().index >= L) {
				deque.removeFirst();
			}
			
			bw.write(deque.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
	}
	
	static class Node {
		int value;
		int index;
		
		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

}

