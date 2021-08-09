package com.algorithm.run.programmers;

import java.util.*;
import java.util.Map.Entry;

public class MenuRenewal {

	public static String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<String>();
        for(int cur : course) {
        	Map<String, Integer> map = new HashMap<String, Integer>();
        	for(String order : orders) {
        		boolean[] visited = new boolean[order.length()];
        		String[] strArr = order.split("");
        		Arrays.sort(strArr);
        		trans(map,strArr, visited, 0, cur);
            }
        	if(map.entrySet().size() > 0) {
        		List<Entry<String, Integer>> entry = new ArrayList<>(map.entrySet());
            	entry.sort(Entry.comparingByValue());
            	int maxOrder = entry.get(entry.size() - 1).getValue();
            	if(maxOrder >  1) {
            		entry.stream().forEach(data -> {
            			if(data.getValue() == maxOrder) {
            				list.add(data.getKey());
            			}
            		});
            	}
        	}
        }
        return list.stream().sorted().toArray(data -> new String[data]);
    }
	
	public static void trans(Map<String, Integer> map, String[] order, boolean[] visited, int start, int r) {
		if(r == 0) {
			String answer = "";
			for(int i = 0 ; i < visited.length ; i++) {
				if(visited[i]) {
					answer += order[i];
				}
			}
			map.put(answer, map.getOrDefault(answer, 0) + 1);
			return;
		}
		
		for(int i = start; i < order.length ; i++) {
			visited[i] = true;
			trans(map, order, visited, i + 1 , r-1);
			visited[i] = false;
		}

	}
	
	public static void main(String[] args) {
		String[] str = {"XYZ", "XWY", "WXA"};
		int[] num = {2,3,4};
		System.out.println(Arrays.toString(solution(str, num)));
	}

}
