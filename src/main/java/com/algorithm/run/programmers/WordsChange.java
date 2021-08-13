package com.algorithm.run.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class WordsChange {
	
	public static class Node{
		private String str;
		private int move;
		private List<String> list;
		
		public Node(String str, int move, List<String> list) {
			this.str = str;
			this.move = move;
			this.list = new ArrayList<String>(list);
		}
		
	}

	public static int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;
        
        Queue<Node> que = new LinkedList<Node>();
        if(Arrays.stream(words).filter(data -> data.equals(target)).collect(Collectors.toList()).size() == 0) {
        	return 0;
        }
        que.add(new Node(begin, 0, Arrays.stream(words).filter(data -> !data.equals(begin)).collect(Collectors.toList())));
        
        while(!que.isEmpty()) {
        	Node node = que.poll();
        	String str = node.str;
        	for(int i = 0; i < node.list.size() ; i++) {
        		List<String> nodeList = new ArrayList<String>(node.list);
        		if(strChk(str, node.list.get(i))) {
        			if(node.list.get(i).equals(target)) {
        				answer = Math.min(answer, node.move + 1);
        			}else {
        				nodeList.remove(node.list.get(i));
            			que.add(new Node(node.list.get(i), node.move + 1, nodeList));
        			}
        		}
        		
        	}
        	
        }
        
        return answer;
    }
	
	public static boolean strChk(String o1, String o2) {
		boolean chk = false;
		int cnt = 0;
		for(int i = 0 ; i < o1.length() ; i++) {
			if(o1.charAt(i) != o2.charAt(i)) {
				cnt++;
			}
			if(cnt >= 2) {
				break;
			}
		}
		
		if(cnt < 2) {
			chk = true;
		}
		
		return chk;
	}
	  
	public static void main(String[] args) {
		String begin = "hit";
		String target= "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cop"};
		System.out.println(solution(begin, target, words));
	}

}
