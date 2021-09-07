package com.algorithm.run.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeaveCompany {
	static int cnt;
	static int[] day;
	static int[] price;
	static int answer = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cnt = Integer.parseInt(br.readLine());
		day = new int[cnt];
		price = new int[cnt];
		
		for(int i = 0 ; i < cnt ; i++) {
			String line = br.readLine();
			day[i]   = Integer.parseInt(line.split(" ")[0]);
			price[i] = Integer.parseInt(line.split(" ")[1]);
		}
		
		for(int i = 0 ; i < cnt ; i++) {
			findPrice(i, 0);
		}
		
		System.out.println(answer); 

	}
	public static void findPrice(int dayIndex, int total) {
		int totalDay = day[dayIndex];
		if(totalDay + dayIndex <= cnt) {
			int totalPrice = price[dayIndex];
			total += totalPrice;
			answer = Math.max(answer, total);
			for(int i = dayIndex + totalDay ; i < cnt ; i++) {
				findPrice(i, total);
				
			}
		}
		
	}

}
