package com.algorithm.run.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class TravelRoot {
	

	public static class Node{
		String start;
		List<String> history;
		List<Integer> index;
		
		public Node(String start, List<String> history, List<Integer> index) {
			this.start = start;
			this.history = new ArrayList<String>(history);
			this.index = new ArrayList<Integer>(index);
		}
	}

	public static String[] solution(String[][] tickets) {
        Queue<Node> que = new LinkedList<Node>();
        PriorityQueue<String> anserQue = new PriorityQueue<String>();
        for(int i = 0 ; i < tickets.length ; i++) {
        	String start = tickets[i][0];
        	String end = tickets[i][1];
        	if(start.equals("ICN")) {
        		List<String> history = new ArrayList<String>();
        		List<Integer> index = new ArrayList<Integer>();
        		history.add(start);
        		index.add(i);
        		que.add(new Node(end, history, index));
        	}
        }
        
        while(!que.isEmpty()) {
        	Node node = que.poll();
        	
        	if(node.index.size() == tickets.length) {
        		String str = node.history.stream().collect(Collectors.joining(","))+ "," + node.start;
        		anserQue.add(str);
        	}
        	
        	for(int i = 0 ; i < tickets.length ; i++) {
            	String start = tickets[i][0];
            	String end = tickets[i][1];
            	if(start.equals(node.start) && !node.index.contains((Integer)i)) {
            		List<String> history = new ArrayList<String>(node.history);
            		List<Integer> index = new ArrayList<Integer>(node.index);
            		history.add(start);
            		index.add(i);
            		que.add(new Node(end, history, index));
            	}
            }
        }
        
        return anserQue.poll().split(",");
	}
	 
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		
		System.out.println(Arrays.toString(solution(tickets)));

	}

}
