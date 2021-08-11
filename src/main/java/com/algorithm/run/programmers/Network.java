package com.algorithm.run.programmers;

import java.util.*;

public class Network {
	static Map<Integer, List<Integer>> map;
	static Map<String, Boolean> answerMap = new HashMap<String, Boolean>();
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        map = new HashMap<Integer, List<Integer>>();
        for(int i = 0 ; i < computers.length ; i++) {
        	for(int j = 0 ; j < computers[0].length ; j++) {
        		if(computers[i][j] == 1) {
        			List<Integer> list = map.getOrDefault(i, new ArrayList<Integer>());
            		list.add(j);
            		map.put(i, list);
        		}
            }
        }
        for(Integer key : map.keySet()) {
        	HashSet<Integer> set = new HashSet<Integer>();
        	find(set, key);
        	
        	List<Integer> list = new ArrayList<Integer>(set);
        	Collections.sort(list);
        	answerMap.put(list.toString(), true);
        }
        
        System.out.println(answerMap);
        return answer;
    }
	
	public static void find(HashSet<Integer> set, int key) {
		set.add(key);
		List<Integer> list = map.get(key);
		for(int i = 0; i < list.size() ; i++ ) {
			if(list.get(i) != key && !set.contains(list.get(i))) {
				find(set, list.get(i));
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[][] arr = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		solution(3, arr);

	}

}
