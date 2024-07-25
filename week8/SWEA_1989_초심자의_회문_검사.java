import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		sc.nextLine();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String str = sc.nextLine();
            int len = str.length();
            
            if(len == 3) {
            	if(str.charAt(0) == str.charAt(2)) {
            		System.out.println("#"+test_case+" 1");
            	} else {
                 System.out.println("#"+test_case+" 0");
             	}
            } else {
                for(int i=0; i<len/2; i++) {
                    if((i+1) == len/2) {
                        System.out.println("#"+test_case+" 1");
                        break;
                    }
                    if(str.charAt(i) == str.charAt(len-1-i)) {
                        continue;
                    } else {
                        System.out.println("#"+test_case+" 0");
                        break;
                    }
                }
            }
            
		}
	}
}