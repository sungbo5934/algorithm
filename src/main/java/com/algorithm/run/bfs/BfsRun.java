package com.algorithm.run.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsRun {
	
	static int H  = 0;
	static int W = 0;
	static int[][] miroArr;
	static boolean[][] visitied;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String hwStr = sc.nextLine();
		H = Integer.parseInt(hwStr.split(" ")[0]);
		W = Integer.parseInt(hwStr.split(" ")[1]);
		
		miroArr = new int[H][W];
		visitied = new boolean[H][W];
		
		for(int i = 0 ; i < H ; i++) {
			String scStr = sc.nextLine();
			System.out.println(scStr);
			for(int j = 0 ; j < scStr.length() ; j++) {
				miroArr[i][j] = Integer.parseInt(scStr.charAt(j)+"");
				visitied[i][j] = false;
			}
		}
		
		bfs(0,0,2,1);
	}
	
	static void bfs(int hStart , int wStart , int hIndex , int wIndex) {
		Queue<Node> que = new LinkedList<Node>();
		que.add(new Node(hStart , wStart , 1));
		
		while(!que.isEmpty()){
			Node node = que.poll();
			visitied[node.x][node.y] = true;
			System.out.println("x : "+ node.x);
			System.out.println("y : "+ node.y);
			//위
			if(node.x - 1 >= 0 
					&& node.x - 1 < H 
					&& miroArr[node.x - 1][node.y] == 1 
					&& visitied[node.x - 1][node.y] == false) {
				que.add(new Node(node.x - 1 , node.y , node.depth + 1));
			}
			//아래
			if(node.x + 1 >= 0 
					&& node.x + 1 < H 
					&& miroArr[node.x + 1][node.y] == 1 
					&& visitied[node.x + 1][node.y] == false) {
				que.add(new Node(node.x + 1 , node.y , node.depth + 1));
			}
			//왼쪽
			if(node.y - 1 >= 0 
					&& node.y - 1 < W 
					&& miroArr[node.x][node.y - 1] == 1 
					&& visitied[node.x][node.y - 1] == false) {
				que.add(new Node(node.x , node.y - 1 , node.depth + 1));
			}
			//오른쪽
			if(node.y + 1 >= 0 
					&& node.y + 1 < W 
					&& miroArr[node.x][node.y + 1 ] == 1 
					&& visitied[node.x][node.y + 1] == false) {
				que.add(new Node(node.x , node.y + 1, node.depth + 1));
			}
			if(visitied[hIndex - 1][wIndex - 1 ]) {
				System.out.println("완료 : "+ node.depth);
				break;
			}
		}
		
	}
	
	static class Node{
		int x;
		int y;
		int depth;
		
		public Node(int x , int y , int depth){
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

}
