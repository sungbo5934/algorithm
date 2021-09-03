package com.algorithm.run.programmers;

import java.util.*;

public class Stock {
	
	static int answer = 0;
	static int totalN = 0 ;
    public static int solution(int n, int[] price) {
    	
    	totalN = n;
        for(int i = 0 ; i < price.length ; i++) {
        	if(price[i] == 0) {
        		Map<Integer,Integer> request = new HashMap<Integer,Integer>();
        		request.put(1, 0);
                dp(request, price, i);
                break;
        	};
        }
        
        return answer;
    }
    
    public static void dp(Map<Integer,Integer> map, int[] price, int index){
    	Map<Integer,Integer> result = new HashMap<Integer,Integer>();
    	for(int key : map.keySet()) {
    		int total = map.get(key);
    		if(total >= price[index + 1]) {
    			if(result.get(key + 1) == null || (result.get(key + 1) != null && total - price[index + 1] > result.get(key + 1))) {
    				result.put(key + 1, total - price[index + 1]);
    			}
    		}else {
    			if(result.get(key) == null || (result.get(key) != null && total > result.get(key))) {
    				result.put(key, total);
    			}
    		}
    		
    		if(key > 0 ) {
    			for(int i = 1 ; i <= key ; i++) {
    				if(result.get(key - i) == null || (result.get(key - i) != null && total + (price[index + 1] * i) > result.get(key - i))) {
        				result.put(key - i, total + (price[index + 1] * i));
        			}
    			}
    		}else {
    			if(result.get(key) == null || (result.get(key) != null && total > result.get(key))) {
    				result.put(key, total);
    			}
    		}
    	}
    	//System.out.println(result);
    	if(index+2 == totalN ) {
    		//System.out.println(map);
    		for(int key : result.keySet()) {
    			int cnt = result.get(key);
    			answer = Math.max(answer, cnt);
    		}
    	}else {
    		dp(result, price, index + 1);
    	}
    }
    
    public static void main(String[] args) {
    	int[] price = {0,1,1,5,15,6,84,1,2,1,1,5,4,8,0,1,5,36,84,3,51,21,3,0,15,1,5,4,5,1,54,6,6,4,2,1,5,4,8,0,1,5,36,84,3,51,21,3,0,15,1,5,4,5,1,54,6,6,4,2};
    	//System.out.println(price.length);
    	//int[] price = {5,5,6,4,8,63,1,0,5,1,2,7,1,0,5};
    	//int[] price = {0,5};
    	//int[] price = {0,9,1,1,1,1,1,1,1,1,1,10};
    	System.out.println(solution(29,price));
    }

}
