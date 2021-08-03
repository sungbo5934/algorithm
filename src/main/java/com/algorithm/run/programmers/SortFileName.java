package com.algorithm.run.programmers;

import java.util.*;

public class SortFileName {
	
	public static String[] solution(String[] files) {

		Arrays.sort(files, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String o1Str = trans(o1);
				String o1Head = o1Str.split(";")[0];
				String o1Number = o1Str.split(";")[1];
				
				String o2Str = trans(o2);
				String o2Head = o2Str.split(";")[0];
				String o2Number= o2Str.split(";")[1];
				
				if(!o1Head.equals(o2Head)) {
					return o1Head.compareTo(o2Head);
				}else {
					long o1Int = Long.parseLong(o1Number);
					long o2Int = Long.parseLong(o2Number);
					
					if(o1Int > o2Int) {
						return 1;
					}else if(o1Int == o2Int) {
						return 0;
					}else {
						return -1;
					}
					
				}
			}
		});
		
	    return files;
	}
	
	public static String trans(String  str) {
		str = str.toLowerCase();
		String head  = "";
		String number = "";
		boolean chk = false;
		for(int i = 0 ; i < str.toCharArray().length ; i++) {
			String value = String.valueOf(str.toCharArray()[i]);
			try {
				int intValue = Integer.parseInt(value);
				number += intValue + "";
				chk = true;
			}catch(Exception e) {
				if(!chk) {
					head += value;
				}else {
					break;
				}
			}
		}
		
		return head+ ";" + number;
	}
	
	public static void main(String[] args) {
		String[] arr2 = {"muzi1.txt", "MUZI1.txt", "muzi001.txt", "muzi1.TX"};
		String[] arr = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II","F-14 4Zomcat", "F-14 3Tomcat"};
		System.out.println(Arrays.toString(solution(arr)));
	}
	 

}
