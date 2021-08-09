package com.algorithm.run.programmers;

import java.util.*;

public class Joystick {
	
	public static class Node{
		private int x;
		private int move;
		private List<Integer> list;
		
		public Node(int x, int move, List<Integer> list) {
			this.list = new ArrayList<Integer>(list);
			this.x = x;
			this.move = move;
		}
	}

	public static int solution(String name) {
		int move = 0;
        int answer = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i < name.length() ; i++) {
        	if(!String.valueOf(name.charAt(i)).equals("A")) {
        		list.add(i);
        		if((int)name.charAt(i) <= 78) {
        			move += (int)name.charAt(i) - 65;
        		}else {
        			move += 90 -(int)name.charAt(i) + 1;
        		}
        	}
        }
        
        Queue<Node> que = new LinkedList<Node>();
        que.add(new Node(0,0, list));
        
        while(!que.isEmpty())
        {
        	Node node = que.poll();
        	
        	if(node.list.size() > 0) {
        		
        		if(node.list.get(0) ==  0) {
            		node.list.remove(0);
            	}
        		
        		if(node.list.get(0) != node.list.get(node.list.size() - 1)) {
        			int move1 = Math.max(node.list.get(0), node.x) - Math.min(node.list.get(0), node.x);
        			int realMove1 = Math.min(name.length() - move1, move1);
        			
        			int move2 = Math.max(node.list.get(node.list.size() - 1), node.x) - Math.min(node.list.get(node.list.size() - 1), node.x);
        			int realMove2 = Math.min(name.length() - move2, move2);
        			
        			if(realMove1 == realMove2) {
        				int x1 = node.list.get(0);
        				int x2 = node.list.get(node.list.size() -1);
        				List<Integer> moveList1 = new ArrayList(node.list);
        				moveList1.remove(0);
        				que.add(new Node(x1,node.move + realMove1, moveList1));
        				List<Integer> moveList2 = new ArrayList(node.list);
        				moveList2.remove(node.list.size() -1);
        				que.add(new Node(x2,node.move + realMove1, moveList2));
        			}else if(realMove1 < realMove2) {
        				int x1 = node.list.get(0);
        				node.list.remove(0);
        				que.add(new Node(x1,node.move + realMove1, node.list));
        			}else {
        				int x2 = node.list.get(node.list.size() -1);
        				node.list.remove(node.list.size() -1);
        				que.add(new Node(x2,node.move + realMove2, node.list));
        			}
        		}else {
        			int move1 = Math.max(node.list.get(0), node.x) - Math.min(node.list.get(0), node.x);
        			int realMove1 = Math.min(name.length() - move1, move1);
        			int x1 = node.list.get(0);
        			node.list.remove(0);
        			que.add(new Node(x1,node.move + realMove1, node.list));
        		}
        	}else {
        		answer = Math.min(answer, node.move);
        	}
        	
        }
        
        
        
        
        return answer + move;
    }
	
	public static void main(String[] args) {
		System.out.println(solution("JAN"));

	}

}
