package com.algorithm.run.programmers;

public class TournamentTree {
	
	public static int solution(int n, int a, int b)
    {
        int answer = 0;
        while(true) {
        	if((int)Math.abs(a - b) == 1 && Math.min(a, b) % 2 == 1) {
        		answer++;
        		break;
        	}else {
        		if(a % 2 ==1) {
        			a = a / 2 + 1;
        		}else {
        			a /= 2;
        		}
        		
        		if(b % 2 ==1) {
        			b = b / 2 + 1;
        		}else {
        			b /= 2;
        		}
        		
        		answer++;
        	}
        }

        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(8, 4, 7));

	}

}
