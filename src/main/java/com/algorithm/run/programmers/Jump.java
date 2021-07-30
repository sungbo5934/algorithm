package com.algorithm.run.programmers;

import java.util.*;

public class Jump {
	
	public static int solution(int n) {
        int ans = 0;

        while(true) {
        	if(n % 2== 0 ) {
        		n /= 2;
        	}else {
        		ans++;
        		n -= 1;
        	}
        	if(n == 0 ) {
        		break;
        	}
        }

        return ans;
    }
	
	public static void main(String args[]) {
		
	}

}
