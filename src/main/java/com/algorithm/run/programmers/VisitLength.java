package com.algorithm.run.programmers;

import java.util.*;

public class VisitLength {
	
	static int x = 5;
	static int y = 5;
	public static int solution(String dirs) {
		
        int answer = 0;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(int i = 0 ; i < dirs.toCharArray().length ; i++) {
        	String order = String.valueOf(dirs.toCharArray()[i]);
        	
        	if(order.equals("U")) {
        		if(y + 1 < 11) {
        			y = y + 1;
        			if(!map.getOrDefault(x+","+y, new ArrayList<String>()).contains("U")) {
        				List<String> Ulist = map.getOrDefault(x+","+y, new ArrayList<String>());
        				Ulist.add("U");
        				map.put(x+","+y, Ulist);
        				
        				List<String> Dlist = map.getOrDefault(x+","+(y-1), new ArrayList<String>());
        				Dlist.add("D");
        				map.put(x+","+(y-1), Dlist);
        				answer++;
        			}
        		}
        	}else if(order.equals("D")) {
        		if(y - 1 > -1) {
        			y = y - 1;
        			if(!map.getOrDefault(x+","+y, new ArrayList<String>()).contains("D")) {
        				List<String> Dlist = map.getOrDefault(x+","+y, new ArrayList<String>());
        				Dlist.add("D");
        				map.put(x+","+y, Dlist);
        				
        				List<String> Ulist = map.getOrDefault(x+","+(y+1), new ArrayList<String>());
        				Ulist.add("U");
        				map.put(x+","+(y+1), Ulist);
        				answer++;
        			}
        		}
        	}else if(order.equals("R")) {
        		if(x + 1 < 11) {
        			x = x + 1;
        			if(!map.getOrDefault(x+","+y, new ArrayList<String>()).contains("R")) {
        				List<String> Rlist = map.getOrDefault(x+","+y, new ArrayList<String>());
        				Rlist.add("R");
        				map.put(x+","+y, Rlist);
        				
        				List<String> Llist = map.getOrDefault((x-1)+","+y, new ArrayList<String>());
        				Llist.add("L");
        				map.put((x-1)+","+y, Llist);
        				answer++;
        			}
        		}
        	}else if(order.equals("L")) {
        		if(x - 1 > -1) {
        			x = x - 1;
        			if(!map.getOrDefault(x+","+y, new ArrayList<String>()).contains("L")) {
        				List<String> Llist = map.getOrDefault(x+","+y, new ArrayList<String>());
        				Llist.add("L");
        				map.put(x+","+y, Llist);
        				
        				List<String> Rlist = map.getOrDefault((x+1)+","+y, new ArrayList<String>());
        				Rlist.add("R");
        				map.put((x+1)+","+y, Rlist);
        				answer++;
        			}
        		}
        	}
        	
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		System.out.println(solution("LULLLLLLU"));
	}
	

}
