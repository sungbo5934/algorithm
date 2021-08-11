package com.algorithm.run.programmers;

import java.util.*;

public class JewelryShopping {
	
	public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Set<String> set =  new HashSet<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Queue<String> que = new LinkedList<String>();
        
        for(String gem : gems) {
        	set.add(gem);	
        }
        
        int length = Integer.MAX_VALUE;
        int startIndex = 0;
        int tempStartIndex = 0;
        
        for(int i = 0 ; i < gems.length ; i++) {
        	String gemNm = gems[i];
        	map.put(gemNm, map.getOrDefault(gemNm, 0) + 1);
        	que.add(gemNm);
        	
        	while(true) {
        		String firstGem = que.peek();
        		if(map.get(firstGem) > 1) {
        			map.put(firstGem, map.get(firstGem) - 1);
        			que.poll();
        			tempStartIndex++;
        		}else {
        			break;
        		}
        	}
        	
        	if(set.size() == map.size() && length > que.size()) {
        		length = que.size();
        		startIndex = tempStartIndex;
        	}
        	
        }
        
        answer[0] = startIndex + 1;
        answer[1] = startIndex + length;
        
        return answer;
    }

	public static void main(String[] args) {
		String[] str = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		System.out.println(Arrays.toString(solution(str)));;

	}

}
