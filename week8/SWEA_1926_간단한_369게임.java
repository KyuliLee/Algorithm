import java.util.*;

class SWEA_1926_간단한_369게임
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int N;
		N=sc.nextInt();
        
        for(int i=1; i<=N; i++) {
            int ii = i;
            StringBuilder result = new StringBuilder("");
            
            while(ii>0) {
                if(ii % 10 == 3 || ii%10 == 6 || ii%10 == 9) result.append("-");
                ii = ii/10;
            }
            
            String str = result.toString();
            if(str.contains("-")) {
                result.append(" ");
                System.out.print(result);
            } else {
                System.out.print(i + " ");
            }
        }
	}
}