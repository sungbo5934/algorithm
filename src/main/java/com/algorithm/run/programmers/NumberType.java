package com.algorithm.run.programmers;

public class NumberType {
	
	public static int solution(int n) {
        int answer = 0;
        int total = 0;
        int index = 0;
        for(int i = n; i >0; i--) {
        	if(total == 0) {
        		index = i;
        	}
        	total+= i;
        	if(total == n) {
        		answer++;
        		total = 0 ;
        		i = index;
        	}else if(total > n) {
        		i++;
        		total = 0 ;
        		i = index;
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		System.out.println(solution(15));

	}

}
