package com.algorithm.run.programmers;

import java.util.*;

public class EatLand {
	
	static Map<String, Integer> map  = new HashMap<String, Integer>();
	
	public static class Node{
		int y;
		int x;
		int sum;
		
		public Node(int y, int x, int sum) {
			this.y = y ;
			this.x = x;
			this.sum = sum;
		}
	}
	
	public static int solution(int[][] land) {
        int answer = 0;
        
        Queue<Node> que = new LinkedList<Node>();
        que.add(new Node(0,0,land[0][0]));
        que.add(new Node(0,1,land[0][1]));
        que.add(new Node(0,2,land[0][2]));
        que.add(new Node(0,3,land[0][3]));
        map.put("0,0", land[0][0]);
        map.put("0,1", land[0][1]);
        map.put("0,2", land[0][2]);
        map.put("0,3", land[0][3]);
        
        
        while(!que.isEmpty()) {
        	Node node = que.poll();
        	if(node.y < land.length - 1) {
        		for(int i = 0 ; i < 4 ; i++) {
        			if(i != node.x && map.getOrDefault(node.y + 1 + "," + i, 0) != node.sum + land[node.y + 1][i]) {
        				que.add(new Node(node.y + 1, i, node.sum + land[node.y + 1][i]));
        				map.put(node.y + 1 + "," + i, node.sum + land[node.y + 1][i]);
        			}
        		}
        	}else {
        		answer = Math.max(answer, node.sum);
        	}
        	
        }

        return answer;
    }

	public static void main(String[] args) {
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1},{4,3,2,1}};
		System.out.println(solution(land));

	}

}
