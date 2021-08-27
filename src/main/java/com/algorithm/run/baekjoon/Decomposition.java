package com.algorithm.run.baekjoon;

import java.util.Scanner;

public class Decomposition {

	public static void main(String[] args) {
		int answer = 0;
		
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		int numN = Integer.parseInt(n);
		
		for(int i = 0 ; i < numN ; i++) {
			int cnt = i;
			String numStr = String.valueOf(i);
			for(int j = 0 ; j <numStr.length() ; j++) {
				cnt += Integer.parseInt(String.valueOf(numStr.charAt(j)));
			}
			
			if(cnt == numN) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
