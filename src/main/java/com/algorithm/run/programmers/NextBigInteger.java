package com.algorithm.run.programmers;

public class NextBigInteger {
	
	public static int solution(int n) {
        int answer = 0;
        String mainStr = Integer.toBinaryString(n);
        int mainCtn = mainStr.length() - mainStr.replace("1", "").length();
        for(int i  = n + 1 ;  ; i++) {
        	String str = Integer.toBinaryString(i);
            int cnt = str.length() - str.replace("1", "").length();
            if(mainCtn == cnt) {
            	answer = i;
            	break;
            }
        }
        
        return answer;
    }

	public static void main(String[] args) {
		System.out.println(solution(15));

	}

}
