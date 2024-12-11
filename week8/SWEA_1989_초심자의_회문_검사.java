import java.util.*;
import java.io.FileInputStream;

class SWEA_1989_초심자의_회문_검사
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		sc.nextLine();

		// 방법 1
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
		// 방법 2
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String str = sc.nextLine();
            StringBuilder sb = new StringBuilder(str);
            String strRev = sb.reverse().toString();
            int len = str.length();
            
            int i=0;
            while (i < len/2) {
            	if(str.charAt(i) == strRev.charAt(i)) {
                	i++;
                } else {
                 	System.out.println("#"+test_case+" 0");
                    break;
                }
            }
            if (i == len/2) {
            	System.out.println("#"+test_case+" 1");
            }
		}
	}
}