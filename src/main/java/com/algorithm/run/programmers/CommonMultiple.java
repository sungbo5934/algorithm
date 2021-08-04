package com.algorithm.run.programmers;

import java.util.*;

public class CommonMultiple {
	
	public static int solution(int[] arr) {
        int answer = 1;
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> numList = new ArrayList<Integer>();
        list.add(1);
        
        loof:
        for(int j = 2 ; ; j++) {
        	int cnt = 0;
        	numList.clear();
        	for(int i = 0 ; i < arr.length ; i++) {
            	if(Arrays.stream(arr).max().getAsInt() < j) {
            		break loof;
            	}
            	if(arr[i] % j == 0) {
            		cnt ++;
            		numList.add(arr[i] / j);
            	}else {
            		numList.add(arr[i]);
            	}
            	
            }
        	if(cnt > 1 ) {
        		list.add(j);
        		arr = numList.stream().mapToInt(data -> data).toArray();
        		j= 1;
        	}
        	
        }
        for(int num : list) {
        	answer *= num;
        }
        for(int num : arr) {
        	answer *= num;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] arr = {3,4,9,16};
		System.out.println(solution(arr));;

	}

}
