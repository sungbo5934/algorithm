package com.algorithm.run.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ClimbMountain {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] answerArr = new String[n];
 		for(int i = 0 ; i < n ; i++) {
			String infoStr = br.readLine();
			int length = Integer.parseInt(infoStr.split(" ")[0]);
			int d = Integer.parseInt(infoStr.split(" ")[1]);
			
			String str = br.readLine();
			answerArr[i] = answer(Arrays.stream(str.split(" ")).mapToInt(data -> Integer.parseInt(data)).toArray(), d);
		}
 		
 		for(int i = 0 ; i < n ; i++) {
			System.out.println(answerArr[i]);
		}
	}
	
	public static String answer(int[] str, int d) {
		int answerNum = 0;
		for(int i  = 1 ; i < str.length ; i++) {
			if(Math.abs(str[i] - str[i - 1]) > d) {
				if(i == str.length -1) {
					return "impossible";
				}else {
					if(str[i] > str[i -1]) {
						int num = str[i] - (str[i -1] + d);
						str[i] = str[i] - num;
						answerNum += num;
					}else if(str[i] < str[i -1]) {
						int num = (str[i -1] - d) - str[i];
						str[i] = str[i] + num;
						answerNum += num;
					}
				}
			}
		}
		return String.valueOf(answerNum);
	}

}
