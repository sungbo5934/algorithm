package com.algorithm.run.programmers;

import java.util.*;

public class DoublePriorityQueue {
	
	public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> maxQue = new PriorityQueue<Integer>((o1, o2) -> {return o2 - o1;});
        PriorityQueue<Integer> minQue = new PriorityQueue<Integer>((o1, o2) -> {return o1 - o2;});
        
        for(int i = 0 ; i < operations.length ; i++) {
        	String method = operations[i].split(" ")[0];
        	int num = Integer.parseInt(operations[i].split(" ")[1]);
        	if(method.equals("I")) {
        		maxQue.add(num);
        		minQue.add(num);
        	}else {
        		if(num < 0) {
        			if(!minQue.isEmpty()) {
        				int min = minQue.poll();
        				maxQue.remove(min);
        			}
        		}else {
        			if(!maxQue.isEmpty()) {
        				int max = maxQue.poll();
        				minQue.remove(max);
        			}
        		}
        	}
        }
        
        if(!maxQue.isEmpty()) {
        	answer[0] = maxQue.poll();
		}else {
			answer[0] = 0;
		}
        
        if(!minQue.isEmpty()) {
        	answer[1] = minQue.poll();
		}else {
			answer[1] = 0;
		}
        return answer;
    }

	public static void main(String[] args) {
		String[] operations = {"I 7","I 5","D -1"};
		System.out.println(Arrays.toString(solution(operations)));

	}

}
