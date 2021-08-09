package com.algorithm.run.programmers;

public class MakeBigNum {

	public static String solution(String number, int k) {
		int max = 0;
		int index = -1;
		StringBuilder sb = new StringBuilder();
		while(true) {
			
			for(int i = 0 ; i <= k ; i++) {
				int num = Integer.parseInt(String.valueOf(number.charAt(i)));
				if(max < num) {
					max = num;
					index = i;
					if(max == 9) {
						break;
					}
				}
				
			}
			k -= index;
			sb.append(String.valueOf(number.charAt(index)));
			number = number.substring(index + 1, number.length());
			max = 0;
			if(0 == k) {
				sb.append(number);
				break;
			}
			if(number.length() <= k) {
				break;
			}
		}
		
		return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(solution("10000000000",1));
	}

}
