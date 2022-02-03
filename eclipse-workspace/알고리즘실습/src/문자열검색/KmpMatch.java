package 문자열검색;

import java.util.Scanner;

public class KmpMatch {
	static int kmpMatch(String txt, String pat) {
		int pt=1;
		int pp=0;
		int[] skip = new int[pat.length() + 1]; // 스킵 배열
		
		skip[pt] = 0;
		while(pt != pat.length()) {
			if(pat.charAt(pt) == pat.charAt(pp)) // pat의 pt번째 문자가 pat의 pp번째 문자와 같을때
				skip[++pt] = ++pp; // 스킵 배열의 pt번째 요소를 증가시킴
			else if(pp == 0)
				skip[++pp] = pp;
			else
				pp = skip[pp]; 
		}
		//검색
		pt = pp = 0;
		while(pt != txt.length() && pp != pat.length()) {
			if(txt.charAt(pt) == pat.charAt(pp)) {
				pt++;
				pp++;
			} else if (pp == 0)
				pt++;
			else
				pp = skip[pp];//스킵
		}
		
		if(pp == pat.length())
			return pt - pp;
		return -1;
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("텍스트 : ");
		String s1 = stdIn.next();
		
		System.out.print("텍스트 : ");
		String s2 = stdIn.next();
		
		int idx = kmpMatch(s1, s2);
		
		if(idx == -1) 
			System.out.print("일치하는 텍스트가 없습니다");
		else {
			int len = 0;
			for(int i=0; i<idx; i++)
				len += s1.substring(i,i+1).getBytes().length;
			len += s2.length();
			
			System.out.println((idx + 1) + "번째 문자부터 일치합니다");
			System.out.println("텍스트 : " + s1);
			System.out.printf(String.format("패턴 : %%%ds\n",len),s2);
		}

	}

}
