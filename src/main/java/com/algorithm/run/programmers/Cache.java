package com.algorithm.run.programmers;

import java.util.*;

public class Cache {

	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		List<String> list = new ArrayList<String>();
		
		for(String city : cities) {
			city = city.toLowerCase();
			int index = list.indexOf(city);
			if(cacheSize != 0 ) {
				if(index < 0 ) {
					answer += 5;
					if(list.size() < cacheSize) {
						list.add(city);
					}else if(list.size() == cacheSize) {
						list.remove(0);
						list.add(city);
					}
				}else {
					answer += 1;
					list.remove(index);
					list.add(city);
				}
			}else {
				answer += 5;
			}
			
		}
		return answer;
	}
	 
	public static void main(String[] args) {
		String[] str = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(solution(0, str));
	}

}
