package com.algorithm.run.programmers;

import java.util.*;
import java.util.Queue;

public class QuardZip {
	
	public static class Node{
		int y;
		int x;
		int endY;
		int endX;
		int cnt;
		
		public Node(int y, int x, int endY, int endX, int cnt) {
			this.y = y;
			this.x = x;
			this.endY = endY;
			this.endX = endX;
			this.cnt = cnt;
		}
		
		public String toString() {
			return "x : "+ x + ", y : "+ y + ", endX : "+ endX + ", endY : "+ endY + ", cnt : "+ cnt;
		}
	}
	static int cnt;
	static int cnt0;
	static int cnt1;
	
	public static int[] solution(int[][] numbers) { 
		
		int[] answer = new int[2];
		Queue<Node> que = new LinkedList<Node>();
		int powCnt = 1;

		if(numbers.length == 1) {
			int index = numbers[0][0];
			if(index == 0) {
				cnt0++;
			}else {
				cnt1++;
			}
		}else {
			que.add(new Node(0, 0, numbers.length/2 -1 , numbers.length/2 -1, 1));
			que.add(new Node(numbers.length/2, 0, numbers.length -1 , numbers.length/2 -1, 1));
			que.add(new Node(0, numbers.length/2, numbers.length/2 -1, numbers.length -1, 1));
			que.add(new Node(numbers.length/2, numbers.length/2, numbers.length -1 , numbers.length -1, 1));
		}
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			int index = 3 ;
			powCnt = node.cnt;
			if(node.x == node.endX && node.y == node.endY) {
				index = numbers[node.y][node.x];
			}else {
				loof1:
					for(int i = node.y ; i <= node.endY ; i++) {
						for(int j = node.x ; j <= node.endX ; j++) {
							if(index == 3) {
								index = numbers[i][j];
							}else {
								if(index != numbers[i][j]) {
									index = 3 ;
									break loof1;
								}
							}
						}
					}
			}
			
			if(index == 3) {
				int sum = numbers.length / (int)Math.pow(2, (node.cnt + 1));
				que.add(new Node(node.y, node.x, sum + node.y - 1, sum + node.x - 1, node.cnt + 1));
				que.add(new Node(sum + node.y, node.x, sum + sum + node.y - 1 , sum + node.x - 1, node.cnt + 1));
				que.add(new Node(node.y, sum + node.x, sum + node.y - 1, sum + + sum + node.x -1, node.cnt + 1));
				que.add(new Node(sum + node.y, sum + node.x, sum + sum + node.y - 1, sum + sum + node.x - 1, node.cnt + 1));
			}else {
				if(index == 0) {
					cnt0++;
				}else {
					cnt1++;
				}
			}
		}
		if(powCnt == 1) {
			if(cnt1 > 0) {
				cnt1 = 1;
			}else {
				cnt0 = 1;
			}
		}
		answer[0] = cnt0;
		answer[1] = cnt1;
		return answer;
	}
	

	public static void main(String[] args) {
		int[][] arr4 = {{0}};
		int[][] arr3 = {{1,1},{1,0}};
		int[][] arr2 = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
		int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
		int[][] arr5 = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
						,{0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1}
						,{0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1}
						,{0,1,0,0,1,1,1,1,0,1,0,0,1,1,1,1}
						,{0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1}
						,{0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1}
						,{0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,1}
						,{0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1}
						,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
						,{0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1}
						,{0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1}
						,{0,1,0,0,1,1,1,1,0,1,0,0,1,1,1,1}
						,{0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1}
						,{0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1}
						,{0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,1}
						,{0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1}};
		System.out.println(Arrays.toString(solution(arr2)));
	}

}
