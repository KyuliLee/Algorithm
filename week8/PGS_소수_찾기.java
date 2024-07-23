package week8;
import java.util.*;

public class PGS_소수_찾기 {
    private static boolean[] visited;
    private static HashSet<Integer> set = new HashSet<>();
    
    public static void main(String[] args) {
    	
    	String numbers = "011";
        
        visited = new boolean[numbers.length()];
        int cnt = 0;
        dfs(numbers, "", 0);
        
        for(Integer num : set) {
            if(isPrime(num)) {
            	cnt++;
            	System.out.println(num);
            }
        }

    }
    static void dfs(String numbers, String num, int depth) {
        if(depth>numbers.length()) return;
        
        for(int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                int newNum = Integer.parseInt(num+numbers.charAt(i));
                set.add(newNum);
                dfs(numbers, Integer.toString(newNum), depth+1);
                visited[i] = false;
            }
        }
    }
    
    static boolean isPrime(int num) {
    	if(num == 1 || num == 0) return false;
        for(int i=2; i*i <= num; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
}