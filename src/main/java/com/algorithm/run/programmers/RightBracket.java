package com.algorithm.run.programmers;

public class RightBracket {
	
	boolean solution(String s) {
        boolean answer = true;
        int answerInt = 0 ;
        s = s.replace("()", "");
        for(int i = 0 ; i < s.toCharArray().length ; i++) {
        	String str = String.valueOf(s.charAt(i));
        	if(str.equals("(")) {
        		answerInt++;
        	}else {
        		answerInt--;
        	}

        	if(answerInt < 0 || s.toCharArray().length - i - 1< answerInt) {
        		answer = false;
        		break;
        	}
        }
        
        if(answerInt !=  0 ) {
        	answer = false;
        }


        return answer;
    }
	
	static boolean solution2(String s) {
        boolean answer = true;
        while(true) {
        	int start = s.length();
        	s = s.replace("()", "");
        	int end  = s.length();
        	if(start == end) {
        		break;
        	}
        }
        if(!s.equals("")) {
        	answer = false;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution2("()"));
	}

}
