package com.algorithm.run.baekjoon;

import java.util.Scanner;

public class Eearth666 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nw = sc.nextLine();
		int n = Integer.parseInt(nw);
		int  cnt = 0;
		for(int i = 666 ; ; i++) {
			String numStr = String.valueOf(i);
			if(numStr.indexOf("666") > -1) {
				cnt++;
			}
			if(cnt == n) {
				System.out.println(i);
				break;
			}
		}
	}

}
