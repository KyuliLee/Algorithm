import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
		
		// 옷의 종류별로 개수를 세서 map에 넣는다.
		for(int i=0; i<clothes.length; i++) {
			if(map.containsKey(clothes[i][1])) {
				map.put(clothes[i][1], map.get(clothes[i][1])+1);
			} else {
				map.put(clothes[i][1], 1);
			}
		}
		
		int ans = 1;
		// map에서 key들을 빼오고 그 key에 해당하는 숫자+1를 곱한다.
		// 숫자+1을 곱하는 이유 : 안 입은 경우도 있으니까
		for(String str : map.keySet()) {
			ans *= map.get(str)+1;
		}
		// -1을 하는 이유 : 아무것도 안 입은 경우를 제외
        return ans-1;
    }
}
