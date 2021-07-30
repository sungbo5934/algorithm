package com.algorithm.run.programmers;

import java.util.*;
import java.util.stream.Collectors;


public class Boat {

	static int cnt;
	static int peopleCnt;
	static int glLimit;
	static List<Integer> list;
	static int start =0;
	static int end;
	
	public static int solution(int[] people, int limit) {
		end = people.length -1;
		Arrays.sort(people);
		glLimit = limit;
		while(true) {
			if(start > end) {
				break;
			}
			
			if(glLimit == people[end]) {
				cnt++;
				end--;
				glLimit = limit;
				continue;
			}else {
				glLimit -= people[end];
			}

			if(glLimit  >= people[start] ) {
				start++;
			}
			
			end--;
			cnt++;
			glLimit = limit;
			
		}
        return cnt;
    }
	
	public static void main(String[] args) {
		int[] arr = {100, 90, 10,50};
		System.out.println(solution(arr,100));
	}
}
