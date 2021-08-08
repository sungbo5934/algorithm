package com.algorithm.run.programmers;

import java.util.*;

public class BracketRotation {
	
	public static int solution(String s) {
        int answer = 0;
        for(int i =0; i <s.length() ; i++) {
        	if(i == 0) {
        		if(chk(s)) {
        			answer++;
        		}
        	}else {
        		s = s.substring(1 , s.length()) + String.valueOf(s.charAt(0));
        		if(chk(s)) {
        			answer++;
        		}
        	}
        }
        
        
        return answer;
    }
	
	
	public static boolean chk(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0 ; i < s.length() ; i++) {
			char cha = s.charAt(i);
			if(i == 0) {
				if(cha == ']' || cha == '}' || cha == ')') {
					return false;
				}
			}
			
			if(cha == ']') {
				if(!stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
				}
			}else if(cha == '}') {
				if(!stack.isEmpty() &&stack.peek() == '{') {
					stack.pop();
				}
			}else if(cha == ')') {
				if(!stack.isEmpty() &&stack.peek() == '(') {
					stack.pop();
				}
			}else {
				stack.push(cha);
			}
			
		}
		
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(solution("][[[]]"));

	}

}
