package com.algorithm.run.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class BuyCard {
	static int cnt;
	static int[] num;
	static double[] avg;
	static String[] str;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cnt = Integer.parseInt(br.readLine());
		num = new int[cnt];
		avg = new double[cnt];
		str = br.readLine().split(" ");
		for(int i = 0 ; i < cnt ; i++) {
			num[i]  = Integer.parseInt(str[i]);
			avg[i]  = Double.parseDouble(str[i]) / (i+1);
		}
		
		dp(cnt);
		System.out.println(answer);

	}
	
	public static void dp(int forCnt) {
		int cur = -1;
		double max = 0;
		for(int i = 0 ; i < forCnt ; i++) {
			double curAng  = avg[i];
			max = curAng;
			cur = i;
		}
		answer = answer + ((forCnt / (cur + 1)) * num[cur]);
		if(forCnt % (cur + 1) == 0) {
			return;
		}else {
			dp(forCnt % (cur + 1));
		}
	}

}
