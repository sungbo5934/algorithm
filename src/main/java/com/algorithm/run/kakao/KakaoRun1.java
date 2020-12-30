package com.algorithm.run.kakao;

import java.util.Scanner;

public class KakaoRun1 {

	static String nation_1;
	static String nation_2;
	static String nation_3;
	static String nation_4;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nationStr = sc.nextLine();

		nation_1 = nationStr.split(" ")[0];
		nation_2 = nationStr.split(" ")[1];
		nation_3 = nationStr.split(" ")[2];
		nation_4 = nationStr.split(" ")[3];
		
		
		
	}

}
